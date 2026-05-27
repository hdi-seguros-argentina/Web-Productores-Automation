# Convenciones - Barbus Web

## 0) Lectura obligatoria antes de programar
- Este archivo es el primer documento que se debe leer antes de hacer cualquier cambio de código, test, locator, feature o step.
- Antes de implementar, revisar estas convenciones y respetarlas estrictamente.
- Regla máxima: no tocar nada que el usuario no haya pedido explícitamente. Si se detecta algo roto, relacionado o tentador de corregir, primero preguntar antes de modificarlo.
- Cada cambio debe limitarse al archivo, método o locator mencionado por el usuario o estrictamente necesario para que ese pedido compile.
- Regla máxima: respetar la forma en que ya están hechos los tests. Si el usuario dice que un flujo es parecido a otro, usar la misma estructura, orden de llamadas, estilo de step/page/locator y nombres equivalentes, cambiando solo la diferencia puntual del nuevo caso.
- No reinterpretar un flujo parecido creando abstracciones, Pages nuevos, wrappers o métodos nuevos si el patrón existente lo resuelve de otra manera.

## 1) Estructura de carpetas
- Features: `src/test/resources/features`
- Steps: `src/test/java/steps`
- Pages: `src/test/java/pages`
- Locators: `src/test/java/locators`
- Runner: `src/test/java/runner`
- Hooks/utility base: `src/main/java/com/core`

## 2) Convención de capas
- `Feature`: define comportamiento de negocio.
- `Step`: orquesta llamadas, sin lógica compleja de UI.
- `Page`: implementa acciones/validaciones de pantalla.
- `Locator`: solo constantes de selectores.
- `MasterPage`: utilidades transversales Playwright (click, waits, css, etc.).

## 3) Convención de lenguaje
- Gherkin en español.
- Nombres de steps en español.
- Mensajes de aserción en español y con contexto útil.
- Commits en español (regla del proyecto).

## 4) Convención de tags
- Base común: `@AUTOMATED`.
- Tipología actual de suite:
  - `@Regression` / `@regresion`
  - `@branding`
  - tags funcionales de flujo (por ejemplo `@COTIZACION`, `@Cotizador`).
- Tag por menú a nivel feature (aplicable a todos sus escenarios):
  - `@Login`
  - `@Home`
  - `@Produccion`
  - `@Emision`
  - `@Cotizador`
  - `@CuentaCorriente`
  - `@Siniestros`
  - `@Cobranzas`

## 5) Convención de escenarios
- Títulos orientados a valor, no a implementación técnica.
- Formato recomendado:
  - `<Módulo> > <Pantalla/flujo>: <resultado esperado>`
- Mantener `Background` para precondiciones comunes (login + ingreso al módulo).
- Evitar duplicar validaciones idénticas dentro del mismo escenario.

## 6) Convención de steps
- Reutilizar steps genéricos existentes antes de crear uno nuevo.
- Antes de modificar o crear lógica en `Page`/`Step`, revisar siempre el Gherkin del escenario completo para entender qué pasos ya se ejecutaron y no repetir acciones ya cubiertas por steps anteriores.
- Antes de crear o modificar un step, buscar un step parecido existente y copiar su forma. Mantener el mismo orden de llamadas y solo insertar o reemplazar las acciones propias del nuevo flujo.
- Si un step valida estilos globales (`input`, `botón`, `tab`), centralizar la lógica en `GenericPage`.
- No hardcodear datos sensibles en steps; usar `.env` o JSON de datos.
- En flujos largos, el `StepDefinition` orquesta la secuencia y llama varios métodos de `Page`, como en `NuevaCotizacion`.
- El `Page` no debe tener un método que represente todo el escenario; debe exponer acciones chicas por pantalla o bloque funcional.
- Declarar los métodos como `public` por defecto en Pages y Steps. No crear métodos privados salvo pedido explícito.
- Los datos combinables de negocio se cargan desde JSON en el step y se pasan al `Page` por modelo.
- Las verificaciones finales importantes deben tener un step Gherkin separado con `Then`, aunque internamente llamen un método de validación del `Page`.
- Los steps tienen que quedar como la mayoría del proyecto: cargar datos, llamar métodos de `Page`/`CommonPage` y nada más. No meter lógica de Playwright, waits, locators ni validaciones complejas en el step.
- Si un step es genérico para varias ramas (por ejemplo guardar o verificar envío de cotización), debe ir en una clase común de steps, no dentro de `HogarSteps`, `AutomovilesSteps` u otra rama puntual.

## 7) Convención de locators
- Priorizar selectores robustos por texto funcional y estructura estable.
- Evitar selectores acoplados a clases dinámicas de UI cuando sea posible.
- Centralizar selectores por módulo en archivos de `locators`.
- Regla estricta: en archivos de `locators` no se usa concatenación con `+` para armar XPath. Cada constante debe contener el XPath completo.
- Regla estricta: si un locator tiene valores variables, se define con `%s` en `locators` y se resuelve con `String.format(...)` en la Page que lo usa.
- Regla estricta: si un locator se usa en más de una Page o en un flujo compartido (por ejemplo Automóviles y Automóviles MyWay), se importa desde el archivo de locators correspondiente; no se duplica ni se declara inline en la Page.
- Los locators se escriben como constantes completas y legibles, igual que el resto del proyecto. No armar locators concatenando una constante base con pedazos de XPath.
- No crear patrones tipo `PANEL_ACTIVO + "//input..."`, `FIRST_ROW + "/td[1]"` o cadenas encadenadas entre locators. Si hace falta un selector, escribir el XPath completo en esa constante.
- Usar `%s` solo para valores variables simples que se resuelven con `String.format`, como textos de botones, opciones, tabs o ramos.
- Si un locator necesita índice, poner el índice directamente en el XPath completo: `(//...)[1]`.
- Los XPath inline dentro de Pages se evitan: si se reutilizan o forman parte de una pantalla, van al archivo de `locators` correspondiente.
- Mantener el estilo existente: `text()`, `normalize-space()`, `contains()`, `ancestor/following` y selectores por `id`/`placeholder` cuando ya están disponibles. No inventar estrategias nuevas sin necesidad.
- No hacer locators excesivamente genéricos que matcheen contenedores padres y elementos hijos a la vez. Si se usa `//*`, validar que no rompa strict mode; preferir el nodo real (`span`, `button`, `input`, `table`) cuando corresponda.

## 8) Convención de pages
- Los Pages implementan acciones chicas y claras de pantalla: seleccionar, ingresar, abrir, validar. No deben representar un escenario completo.
- Si una acción ya existe en un Page parecido, seguir ese mismo estilo. No mover lógica de un Step a un Page ni de un Page a un Step si el patrón del flujo parecido no lo hace así.
- Los Pages usan locators importados desde `locators`; no construyen XPath largos inline salvo algo puntual y no reutilizable.
- Los Pages usan métodos del framework (`auto_setClickElement`, `auto_setTextToInput`, `auto_waitForElementVisibility`, `auto_verifyVisibility`, `auto_verifyVisibilities`, etc.).
- Regla estricta: si el pedido o el step dice hacer click, el Page debe hacer `auto_setClickElement(LOCATOR)` y nada más, salvo que el usuario pida explícitamente otra cosa.
- Regla estricta: si el pedido o el step dice ingresar/setear texto, el Page debe hacer `auto_setTextToInput(LOCATOR, valor)` y nada más, salvo que el usuario pida explícitamente otra cosa.
- Regla estricta: si el pedido o el step dice verificar un elemento, el Page debe usar `auto_verifyVisibility(LOCATOR)` para un elemento o `auto_verifyVisibilities(...)` para varios, sin crear wrappers con lógica extra.
- No crear métodos tipo `clickYEsperar`, `seleccionarConEspera`, `esperarSpinnerSiExiste`, `clickConSpinner`, `setTextoConRetry` ni variantes parecidas para acciones simples. Los helpers de `MasterPage` ya centralizan esas necesidades.
- No agregar `auto_waitForElementInvisibility`, spinner, `waitForTimeout`, retry, validaciones o assertions alrededor de un click/texto/verificación si no está pedido explícitamente.
- Para validar un elemento, usar `auto_verifyVisibility`; para esperar antes de accionar, usar `auto_waitForElementVisibility`.
- Si se valida un conjunto de elementos, usar `auto_verifyVisibilities` y locators definidos.
- No usar `Locator.WaitForOptions`, `WaitForSelectorState`, `evaluate`, loops manuales ni esperas custom si existe helper en `MasterPage`.
- No crear helpers privados nuevos si la acción se puede expresar con los helpers existentes y un locator. Si hace falta un método auxiliar, mantenerlo simple y público por defecto.

## 9) Convención de waits y estabilidad
- Usar waits explícitos utilitarios (`auto_waitForElementVisibility`, etc.).
- Usar estrictamente los métodos existentes de `MasterPage` para acciones y esperas (`auto_waitForElementVisibility`, `auto_verifyVisibility`, `auto_verifyVisibilities`, `auto_setClickElement`, etc.). No inventar métodos custom con `Locator.WaitForOptions`, `evaluate`, loops manuales o lógica propia si ya existe un helper del framework.
- Evitar `waitForTimeout` salvo casos justificados de transición visual.
- Si se agrega una espera estatica por pedido explicito o transicion visual, usar siempre el formato `page.get().waitForTimeout(300);`.
- Ante flakiness, preferir reintento controlado (ejemplo: `clickConReintento`).
- Para esperar listados con cards, no inventar validaciones por datos ni usar índices salvo pedido explícito. Usar el helper de visibilidad sobre el locator general de la card.

## 10) Convención de validación visual
- Cuando un componente tenga variantes de estilo por foco/estado, documentar y tolerar ambas variantes de forma acotada al componente.
- No relajar validaciones globales para resolver un caso particular.

## 11) Convención de ejecución
- Propiedades clave en `pom.xml`:
  - `tagExecution`
  - `selectedBrowser`
  - `navigateUrl`
  - `mode` (`Local` / `Grid`)
- Comandos de referencia:
  - `mvn clean test`
  - `mvn clean test -DtagExecution="@branding"`
  - `mvn clean test -PLocalChromium`
  - `mvn clean test -PGridChromiumParallel -DtagExecution="@Regression"`

## 12) Criterios para cambios futuros
- No tocar pruebas de `NuevaCotizacion` sin pedido explícito.
- Si se corrige un bug real de negocio (ej.: tarjeta de crédito), conservar el fix y no revertirlo por estabilidad visual.
- Si un test falla por validación de estilo:
  1. confirmar estado real del componente (activo/inactivo)
  2. ajustar validación de forma puntual por input/botón
  3. evitar impacto en escenarios de otros módulos.

## 13) Checklist rápido antes de merge
- Feature con tag de menú correcto.
- Escenario con título de valor funcional.
- Step reutilizable o justificado.
- Locator en archivo de `locators` del módulo.
- Sin credenciales hardcodeadas.
- Corre al menos en secuencial para el tag afectado.
