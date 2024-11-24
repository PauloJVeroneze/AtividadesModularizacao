import java.util.Scanner;

public class MiniChatbot {

    public String responderSaudacao(String entrada) {
        if (entrada.toLowerCase().contains("oi") || entrada.toLowerCase().contains("olá")) {
            return "Olá! Como posso ajudar?";
        }
        return null;
    }

    public String responderNome(String entrada) {
        if (entrada.toLowerCase().contains("qual é o seu nome") || entrada.toLowerCase().contains("seu nome")) {
            return "Eu sou o MiniChatbot!";
        }
        return null;
    }

    public String responderComoEsta(String entrada) {
        if (entrada.toLowerCase().contains("como você está")) {
            return "Estou funcionando bem, obrigado!";
        }
        return null;
    }

    public String respostaPadrao() {
        return "Desculpe, não entendi a pergunta. Pode reformular?";
    }

    public String responder(String entrada) {
        String resposta;

        resposta = responderSaudacao(entrada);
        if (resposta != null) return resposta;

        resposta = responderNome(entrada);
        if (resposta != null) return resposta;

        resposta = responderComoEsta(entrada);
        if (resposta != null) return resposta;

        return respostaPadrao();
    }

    public static void main(String[] args) {
        MiniChatbot chatbot = new MiniChatbot();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá! Eu sou o MiniChatbot. Como posso te ajudar hoje?");

        while (true) {
            System.out.print("Usuário: ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("MiniChatbot: Tchau! Até a próxima.");
                break;
            }

            String resposta = chatbot.responder(entrada);
            System.out.println("MiniChatbot: " + resposta);
        }

        scanner.close();
    }
}
