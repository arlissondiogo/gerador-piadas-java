package br.com.estudoAPI.util;

import br.com.estudoAPI.model.Piadas;
import java.util.Scanner;

public class ConsoleUtil {

    private static final Scanner sc = new Scanner(System.in);

    public static String lerCategoria() {
        System.out.println("\n======================================");
        System.out.println("       🤣  GERADOR DE PIADAS 🤣");
        System.out.println("======================================");
        System.out.println("Categorias disponíveis:\n");
        System.out.println("  Any         → Qualquer categoria");
        System.out.println("  Programming → Piadas de programador 💻");
        System.out.println("  Misc        → Diversas / aleatórias");
        System.out.println("  Pun         → Trocadilhos 😜");
        System.out.println("  Spooky      → Assustadoras 👻");
        System.out.println("  Christmas   → Natalinas 🎄");
        System.out.println("--------------------------------------");
        System.out.print("Digite uma categoria: ");

        String categoria = sc.nextLine().trim();

        if (categoria.equalsIgnoreCase("dark")) {
            System.out.println("⚠️ Categoria 'Dark' foi desativada por conter conteúdo ofensivo.");
            System.out.println("Usando categoria 'Any' no lugar.\n");
            categoria = "Any";
        }

        return categoria;
    }

    public static void exibirPiada(Piadas piada) {
        System.out.println("\n--------------------------------------");
        System.out.println("🃏  PIADA  🃏");
        System.out.println("--------------------------------------");

        if (piada == null) {
            System.out.println("⚠️  Nenhuma piada encontrada!");
            return;
        }

        System.out.println("😄 " + piada.setup());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ignored) {}
        System.out.println("👉 " + piada.delivery());

        System.out.println("--------------------------------------\n");
    }

    public static boolean desejaContinuar() {
        System.out.print("Quer ver outra piada? (s/n): ");
        String resposta = sc.nextLine().trim().toLowerCase();
        return resposta.equals("s") || resposta.equals("sim");
    }

    public static void fechar() {
        sc.close();
    }
}
