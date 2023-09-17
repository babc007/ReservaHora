Feature: Ingreso de nombre de usuario y contraseña incorrectos

Scenario: Ingresar datos de inicio de sesión incorrectos
  Given que estoy en la página de inicio de sesión
  When ingreso un nombre de usuario y contraseña incorrectos
  And presiono el botón de inicio de sesión
  Then debería ver un mensaje de error
