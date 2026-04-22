# Skills - Barbus Web

## 1) Skill de Login
- Abrir la web desde `.env` (`NAVIGATE_URL`).
- Ingresar credenciales desde `.env` (`USER`, `PASS`).
- Validar ingreso exitoso y elementos de pantalla de login.

## 2) Skill de navegación por menú principal
- Flujo base reutilizable:
  1. login
  2. ingreso a Home
  3. selección de intermediario
  4. ingreso al módulo objetivo
- Módulos cubiertos:
  - Home
  - Producción
  - Emisión
  - Cotizador
  - Cuenta Corriente
  - Siniestros
  - Cobranzas
  - NuevaCotizacion (subcarpeta específica)

## 3) Skill de validación visual/UI
- Validación de inputs, botones, tabs, títulos, subtítulos, íconos y paginados.
- Verificación de estilos CSS (color, borde, fondo, fuente) con AssertJ.
- Tolerancias puntuales en algunos inputs según estado activo/inactivo.

## 4) Skill de ejecución multi-modo
- Ejecución secuencial (`testng-sequential.xml`).
- Ejecución paralela (`testng-parallel.xml`).
- Ejecución cross-browser (`testng-crossbrowser.xml`) con Chromium/Firefox/Webkit.
- Filtrado por tags con `-DtagExecution`.

## 5) Skill de evidencia y reporte
- Screenshot automático en fallas (`@After` hook).
- Reporte Cucumber JSON en `target/cucumber-reports/cucumber.json`.
- Integración con Extent Reports (`extentreports-cucumber7-adapter`).
