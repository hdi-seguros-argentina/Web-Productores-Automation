# Convenciones - Barbus Web

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
- Si un step valida estilos globales (`input`, `botón`, `tab`), centralizar la lógica en `GenericPage`.
- No hardcodear datos sensibles en steps; usar `.env` o JSON de datos.

## 7) Convención de locators
- Priorizar selectores robustos por texto funcional y estructura estable.
- Evitar selectores acoplados a clases dinámicas de UI cuando sea posible.
- Centralizar selectores por módulo en archivos de `locators`.

## 8) Convención de waits y estabilidad
- Usar waits explícitos utilitarios (`auto_waitForElementVisibility`, etc.).
- Evitar `waitForTimeout` salvo casos justificados de transición visual.
- Ante flakiness, preferir reintento controlado (ejemplo: `clickConReintento`).

## 9) Convención de validación visual
- Cuando un componente tenga variantes de estilo por foco/estado, documentar y tolerar ambas variantes de forma acotada al componente.
- No relajar validaciones globales para resolver un caso particular.

## 10) Convención de ejecución
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

## 11) Criterios para cambios futuros
- No tocar pruebas de `NuevaCotizacion` sin pedido explícito.
- Si se corrige un bug real de negocio (ej.: tarjeta de crédito), conservar el fix y no revertirlo por estabilidad visual.
- Si un test falla por validación de estilo:
  1. confirmar estado real del componente (activo/inactivo)
  2. ajustar validación de forma puntual por input/botón
  3. evitar impacto en escenarios de otros módulos.

## 12) Checklist rápido antes de merge
- Feature con tag de menú correcto.
- Escenario con título de valor funcional.
- Step reutilizable o justificado.
- Locator en archivo de `locators` del módulo.
- Sin credenciales hardcodeadas.
- Corre al menos en secuencial para el tag afectado.
