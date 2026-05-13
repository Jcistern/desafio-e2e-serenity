Feature: Compra completa en SauceDemo

	Background:
		Given el usuario inicia sesión en SauceDemo
		When ordena los productos por precio de menor a mayor

	@compra-saucedemo-simple
	Scenario: El usuario realiza una compra exitosa de principio a fin
		And agrega el primer producto al carrito
		And procede al carrito y confirma el producto
		And completa el checkout con los datos del archivo
		Then debería ver el mensaje "Thank you for your order!"

	@compra-saucedemo-outline
    Scenario Outline: El usuario realiza una compra exitosa con diferentes datos
		And agrega el primer producto al carrito
		And agrega el segundo producto al carrito
		And verifica que hay 2 productos en el carrito
		And procede al carrito y confirma los productos
		And completa el checkout con nombre "<nombre>", apellido "<apellido>", postal "<postal>"
		Then debería ver el mensaje "Thank you for your order!"

	Examples:
		| nombre 	| apellido  | postal 	|
		| Juan		| Cisterna	| 8320000	|
		| María		| García	| 7500000	|
		| Carlos	| López		| 9000000	|