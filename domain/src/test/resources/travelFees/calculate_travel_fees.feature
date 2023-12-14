Feature: as a travel agency, I want to calculate travel fees depending on the departure and destination trip
  The travel price is computed using the travel fees and the agency fees added together.

  Scenario Outline: Determine the fees for a supported destination
    Given the trip is from "<departure>" to "<destination>"
    And the ticketPrice is "<ticketPrice>"
    And the  travel fees are "<travelFees>"€ and the agency fees are "<agencyFees>"€
    When the system calculate the trip price
    Then the trip price is "<travelPrice>"€

    Examples:
      | departure | destination | ticketPrice | travelFees | agencyFees | travelPrice  |
      | Paris     | New-York    | 1000        | 200        | 50         | 1250         |

