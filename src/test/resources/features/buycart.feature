Feature: Add a product to the shopping cart wong

  Scenario: Add a product to the shopping cart
    Given Candidate select the category tecnology
    When Add to shopping cart the 'Huawei FreeBuds 3i Negro'
    Then Check if the product was added to the cart VACIAR CARRITO
