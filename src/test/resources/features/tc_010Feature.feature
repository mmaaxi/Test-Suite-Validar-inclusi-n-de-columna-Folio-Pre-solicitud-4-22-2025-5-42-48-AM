Feature: Validate inclusion of 'Folio Pre solicitud' column
  Scenario: Verify presence and emptiness of 'Folio Pre solicitud' column in report
    Given the report is exported
    When I open the Excel report to locate the 'Ramo' field
    Then I should identify the 'Ramo' field
    When I check for the column 'Folio Pre solicitud' to the right of 'Ramo'
    Then the 'Folio Pre solicitud' column should exist in the correct position without any data