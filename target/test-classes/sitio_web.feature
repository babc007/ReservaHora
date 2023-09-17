Feature:  prueba con Cucumber y Selenium

  Scenario: Abrir un sitio web
    Given Estoy en la página de inicio
    When Hago clic en el enlace "Contacto"
    Then Debería ver la página de contacto
