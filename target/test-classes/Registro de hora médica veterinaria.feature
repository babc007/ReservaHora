Feature: Registro de hora médica veterinaria

Scenario: Registrar una hora médica veterinaria
  Given que estoy en la página de registro de hora médica
  When ingreso los detalles de la hora médica
  And presiono el botón de registro
  Then debería ver un mensaje de confirmación
