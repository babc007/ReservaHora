Feature: Ingreso de nombre de usuario

Scenario: Ingresar nombre de usuario válido
  Given que estoy en la página de inicio de sesión
  When ingreso el nombre de usuario almacenado en la BD
  And presiono el botón de inicio de sesión
  Then debería estar en la página de inicio

