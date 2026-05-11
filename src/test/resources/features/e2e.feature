Feature: Compra completa en SauceDemo

	Scenario: El usuario realiza una compra exitosa de principio a fin
		Given el usuario está en la página de login
		When ingresa las credenciales desde el archivo de datos
		And ordena los productos por precio de menor a mayor
		And agrega el primer producto al carrito
		And procede al carrito y confirma el producto
		And completa el checkout con los datos del archivo
		Then debería ver el mensaje "Thank you for your order!"