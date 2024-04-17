import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite o dia da semana e  a quantidade de cachorros para banho: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Data: ");
        String data = sc.nextLine();
        System.out.println("Quantidade de cachorros pequenos: ");
        int cachorrosPequenos = sc.nextInt();
        System.out.println("Quantidade de cachorros grandes: ");
        int cachorrosGrandes = sc.nextInt();
        System.out.println("-------------------------------------");

        double meuCanilFelizCost = MeuCanilFeliz(data, cachorrosPequenos, cachorrosGrandes);
        double vaiRexCost = VaiRex(data, cachorrosPequenos, cachorrosGrandes);
        double chowChawgasCost = ChowChawgas(cachorrosPequenos, cachorrosGrandes);

        System.out.printf("Meu Canil Feliz: R$%.2f%n", meuCanilFelizCost);
        System.out.printf("Vai Rex: R$%.2f%n", vaiRexCost);
        System.out.printf("ChowChawgas: R$%.2f%n", chowChawgasCost);

        double menorCusto = Math.min(meuCanilFelizCost, Math.min(vaiRexCost, chowChawgasCost));
        if (menorCusto == meuCanilFelizCost) {
            System.out.println("O melhor pet shop para banho de cachorros é Meu Canil Feliz.");
        } else if (menorCusto == vaiRexCost) {
            System.out.println("O melhor pet shop para banho de cachorros é Vai Rex.");
        } else {
            System.out.println("O melhor pet shop para banho de cachorros é ChowChawgas.");
        }
    }

    public static double MeuCanilFeliz(String data, int cachorroPequeno, int cachorroGrande){
        double preco = 0;
        if (data.equalsIgnoreCase("Sabado") || data.equalsIgnoreCase("Domingo")) {
            preco = (20.00 * cachorroPequeno) * 1.2 + (40.00 * cachorroGrande) * 1.2;
        } else {
            preco = (20.00*cachorroPequeno) + (40.00*cachorroGrande);
        }
        return preco;
    }

    public static double VaiRex(String data, int cachorroPequeno, int cachorroGrande){
        double preco = 0;
        if (data.equalsIgnoreCase("Sabado") || data.equalsIgnoreCase("Domingo")) {
            preco = (20.00 * cachorroPequeno) + (55.00 * cachorroGrande);
        } else {
            preco = (15.00*cachorroPequeno) + (45.00*cachorroGrande);
        }
        return preco;
    }

    public static double ChowChawgas(int cachorroPequeno, int cachorroGrande){
        return (30.00*cachorroPequeno) + (45.00*cachorroGrande);
    }

    /**
     * @param data
     * @return
     * @throws ParseException
     */
    public String diaDaSemana(String data) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = format.format(format.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String diaDaSemana = "";
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(format.parse(data));
        int dayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);

        diaDaSemana = switch (dayOfWeek) {
            case 1 -> "Domingo";
            case 2 -> "Segunda";
            case 3 -> "Terça";
            case 4 -> "Quarta";
            case 5 -> "Quinta";
            case 6 -> "Sexta";
            case 7 -> "Sábado";
            default -> "Erro";
        };

        return diaDaSemana;
    }
}