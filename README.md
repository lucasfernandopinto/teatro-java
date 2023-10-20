# Reservas no teatro

Os lugares de um teatro costumam ser identificados através de filas e colunas. O serviço de
reserva mantém um mapa que indica os lugares reservados e os ainda livres. Como lugares
reservados entende-se como pedidos de reservas (com pagamento ainda não efetuado) e
lugares comprados (com pagamento já efetuado). Se um pedido de reserva não for confirmado
(pagamento efetuado), este poderá ser vendido a outra pessoa. Como exemplo, vamos
considerar um teatro com M = 15 filas, numeradas de 0 à 14, cada fila com N = 15
cadeiras, conforme ilustrado a seguir

![image](https://github.com/lucaspinto-dev/Teatro-java/blob/6fef55d06a24a5cd40ab056b3d276b5ccdf8f257/teatro.png)

Desenvolva um sistema para gerenciar as reservas de um espetáculo. O sistema deve
possuir menus com acesso para uma área administrativa e área de cliente. Nelas:
 - o menu da área administrativa deve permitir:
	 - modificar o valor do ingresso (o valor padrão deve ser R$ 50,00)
	 - visualizar o mapa de assentos
	 - fornecer um relatório com as seguintes informações:
		 - quantidades totais de lugares livres, reservados e confirmados
		 - número total de ingressos de estudantes
		 - valor total arrecadado com os ingressos.
 - e o menu da área de clientes deve permitir:
	 - visualizar o mapa de assentos;
	 - realizar e cancelar reservas. Ao reservar deve ser informado se o cliente é estudante (estudante paga metade do valor do ingresso);
	 - com uma reserva realizada, "receber" o pagamento e confirmar a reserva,
marcando o assento como ocupado.
