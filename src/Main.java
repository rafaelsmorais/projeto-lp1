import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scNL = new Scanner(System.in);
        Locador locador = new Locador();
        Inquilino inquilino = new Inquilino();
        Imovel imovel = new Imovel();
        Contrato contrato = new Contrato();
        boolean repetir = false;
        do {
            System.out.println("Escolha a operação que deseja realizar:");
            System.out.println("1-Novo Contrato de Locação");
            System.out.println("2-Detalhes de Contrato");
            System.out.println("3-Cálculo de Multa");
            System.out.println("4-Corrigir Contrato Pela Inflação");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Informe o tipo de Imóvel a ser cadastrado: [Casa|Apartamento|Terreno]");
                    String tipoImovel = scNL.nextLine();
                    imovel.setTipoImovel(Tipo.valueOf(tipoImovel));
                    System.out.println("Informe nome do Locador");
                    String nomeLocador = scNL.nextLine();
                    System.out.println("Informe cpf do Locador");
                    String cpfLocador = scNL.nextLine();
                    locador.setNome(nomeLocador);
                    locador.setCpf(cpfLocador);
                    System.out.println("Informe nome do Inquilino");
                    String nomeInquilino = scNL.nextLine();
                    System.out.println("Informe cpf do Inquilino");
                    String cpfInquilino = scNL.nextLine();
                    inquilino.setNome(nomeInquilino);
                    inquilino.setCpf(nomeInquilino);
                    System.out.println("Informe o valor do contrato em reais:");
                    double valorAluguel = sc.nextDouble();
                    contrato.setImovel(imovel);
                    contrato.setLocador(locador);
                    contrato.setInquilino(inquilino);
                    contrato.setValorAluguel(valorAluguel);
                    contrato.setDataContrato();
                    System.out.println("Imóvel Cadastrado com Sucesso!");
                    break;
                case 2:
                    System.out.println(contrato.toString());
                    break;
                case 3:
                    System.out.println("Valor da multa de atraso do aluguel: R$" + contrato.multaAtraso());
                    break;
                case 4:
                    System.out.println("Informe a taxa percentual do INCC:");
                    double taxaPorcento = sc.nextDouble();
                    double taxaDecimal = taxaPorcento / 100;
                    contrato.corrigirInflacao(taxaDecimal);
                    System.out.println("Novo valor do aluguel: R$" + contrato.getValorAluguel());
                    break;
            }
            System.out.println("Deseja realizar mais alguma operação? [S|N]");
            String vaiRepetir = scNL.nextLine();
            if (vaiRepetir.equalsIgnoreCase("s")) {
                repetir = true;
            } else if (vaiRepetir.equalsIgnoreCase("n")) {
                repetir = false;
            }
        } while (repetir);
    }
}