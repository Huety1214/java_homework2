import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * 範例 3：java.net — 本機 TCP 回音伺服器與客戶端
 * 使用類別：ServerSocket、Socket、InetAddress、SocketTimeoutException
 * 伺服器在背景 Thread 執行，客戶端送出訊息，伺服器回傳大寫版本。
 */
public class EchoChat {

    static void serve(ServerSocket server) {
        try (Socket client = server.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8), true)) {
            System.out.println("[Server] 連線來自 " + client.getInetAddress().getHostAddress());
            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals("bye")) { out.println("BYE"); break; }
                out.println("ECHO: " + line.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("[Server] 錯誤：" + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        // port 0 讓系統自動挑選可用的埠號
        try (ServerSocket server = new ServerSocket(0, 1, InetAddress.getLoopbackAddress())) {
            int port = server.getLocalPort();
            System.out.println("[Server] 啟動於 port " + port);
            Thread serverThread = new Thread(() -> serve(server));
            serverThread.start();

            try (Socket socket = new Socket(InetAddress.getLoopbackAddress(), port)) {
                socket.setSoTimeout(3000);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
                for (String msg : new String[]{"hello", "java.net is easy", "bye"}) {
                    out.println(msg);
                    System.out.println("[Client] 送出：" + msg + "  ->  收到：" + in.readLine());
                }
            } catch (SocketTimeoutException e) {
                System.err.println("[Client] 等待回應逾時");
            }
            serverThread.join();
        }
        System.out.println("連線結束");
    }
}
