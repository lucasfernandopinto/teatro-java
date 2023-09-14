import java.util.Scanner;

public class Teatro {

    static Scanner entrada = new Scanner(System.in);
    static int l = 15, c = 15;
    static int valorIngresso = 50;
    static boolean[][] cadeiras = new boolean[l][c];
    static boolean[][] confirmado = new boolean[l][c];
    static boolean estudante = false;

    private static void exibirMenuPrincipal() {
        System.out.println("Bem vindos ao Sistema de reservas do teatro do Lucas");
        System.out.println("MENU");
        System.out.println("1 - Área administrativa");
        System.out.println("2 - Área de clientes");
        System.out.println("0 - Sair");
    }

    private static void exibirTeatro() {
        System.out.println("################################");
        System.out.println("             PALCO              ");
        System.out.println("################################");
        System.out.println("   0 0 0 0 0 0 0 0 0 0 1 1 1 1 1");
        System.out.println("   0 1 2 3 4 5 6 7 8 9 0 1 2 3 4");
        for (int i = 0; i < l; i++) {
            if (i < 10) {
                System.out.printf("0%d ", i);
            } else {
                System.out.print(i + " ");
            }
            for (int j = 0; j < c; j++) {
                if (cadeiras[i][j] && !confirmado[i][j]) {
                    System.out.print("R ");
                } else if (cadeiras[i][j] && confirmado[i][j]) {
                    System.out.print("X ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

    public static void gerarRelatorio() {
        int livres = 0;
        int reservadas = 0;
        int confirmados = 0;
        int estudantes = 0;
        float valorArrecadado = 0;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (!cadeiras[i][j]) {
                    livres++;
                } else if (cadeiras[i][j]) {
                    reservadas++;
                }
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                if (cadeiras[i][j] && cadeiras[i][j] == true) {
                    estudantes++;
                }
            }
        }

        valorArrecadado = confirmados * valorIngresso;

        System.out.println("Relatório de reservas");
        System.out.println("Quantidade de cadeiras livres: " + livres);
        System.out.println("Quantidade de cadeiras reservados: " + reservadas);
        System.out.println("Quantidade de cadeiras confirmados: " + confirmados);
        System.out.println("Quantidade de ingressos de estudantes: " + estudantes);
        System.out.println("Valor total arrecadado: R$" + valorArrecadado);
    }

    private static void reservar() {
        int linha, coluna;
        String resp;

        System.out.println("Informe o número da linha:");
        linha = entrada.nextInt();
        System.out.println("Informe o número da coluna:");
        coluna = entrada.nextInt();

        if (cadeiras[linha][coluna]) {
            System.out.println("Assento ocupado.");
            return;
        }

        System.out.println("Você é estudante? (s/n)");
        resp = entrada.next();

        cadeiras[linha][coluna] = true;

        int valor = valorIngresso;
        if (resp.equals("s")) {
            valor = valorIngresso / 2;
            estudante = true;
        }else{
            valor = valorIngresso;
            estudante = false;
        }

        System.out.println("Reserva realizada com sucesso.");
        System.out.println("Valor da reserva: R$" + valor);

    }

    public static void confirmarReserva() {
        int linha, coluna, valor=0, valorPago;
        String resp;

        System.out.println("Informe o número da linha:");
        linha = entrada.nextInt();
        System.out.println("Informe o número da coluna:");
        coluna = entrada.nextInt();

        if (!cadeiras[linha][coluna]) {
            System.out.println("Assento não reservado.");
            return;
        }

        System.out.println("Você é estudante? (s/n)");
        resp = entrada.next();

        System.out.println("Informe o valor do pagamento:");
        valorPago = entrada.nextInt();

        if(resp.equals("s")){
            valor = valorIngresso / 2;
        }else{
            valor = valorIngresso;
        }

        if (valor != valorIngresso) {
            System.out.println("O valor do pagamento deve ser igual ao valor do ingresso.");
            return;
        }

        confirmado[linha][coluna] = true;

        System.out.println("Reserva confirmada com sucesso.");
    }

    private static void cancelarReserva() {
        int linha, coluna;

        System.out.println("Informe o número da linha:");
        linha = entrada.nextInt();
        System.out.println("Informe o número da coluna:");
        coluna = entrada.nextInt();

        if (!cadeiras[linha][coluna]) {
            System.out.println("Assento não reservado.");
            return;
        }

        cadeiras[linha][coluna] = false;

        System.out.println("Reserva cancelada com sucesso.");
    }

    public static void main(String[] args) {
        int op = -1;

        while (op != 0) {
            exibirMenuPrincipal();
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    while (true) {
                        System.out.println("1 - Modificar valor do ingresso");
                        System.out.println("2 - Visualizar mapa de cadeiras");
                        System.out.println("3 - Gerar relatório");
                        System.out.println("0 - Voltar");
                        op = entrada.nextInt();

                        switch (op) {
                            case 1:
                                // Modificar valor do ingresso
                                System.out.println("Informe o novo valor do ingresso:");
                                valorIngresso = entrada.nextInt();
                                break;

                            case 2:
                                exibirTeatro();
                                break;

                            case 3:
                                gerarRelatorio();

                            case 0:
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    }

                case 2:

                    while (true) {
                        System.out.println("1 - Visualizar mapa de cadeiras");
                        System.out.println("2 - Realizar reserva");
                        System.out.println("3 - Cancelar reserva");
                        System.out.println("4 - Confirmar Reserva");
                        System.out.println("0 - Voltar");
                        op = entrada.nextInt();

                        switch (op) {
                            case 1:
                                exibirTeatro();
                                break;

                            case 2:
                                reservar();
                                break;

                            case 3:
                                cancelarReserva();
                                break;

                            case 4:
                                confirmarReserva();
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    }

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

}
