Feature: Compra completa en SauceDemo

	Scenario: El usuario realiza una compra exitosa de principio a fin
		Given el usuario inicia sesión en SauceDemo
		When ordena los productos por precio de menor a mayor
		And agrega el primer producto al carrito
		And procede al carrito y confirma el producto
		And completa el checkout con los datos del archivo
		Then debería ver el mensaje "Thank you for your order!"