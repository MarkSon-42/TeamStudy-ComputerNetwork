 package chat;
 public class ServerEx{
    public static void main(String[] args) {
        
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in = null;
        BufeeredWriter out = null;
        Scanner sc = new Scanner(System.in);
 
        try {
            serever = new ServerSocket(9999);
            System.out.println("연결 대기중....");
            socket = server.accept();
            System.out.println("연결되었습니다");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufeeredWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true){
                String inMsg = in.readLine();
                if(inMsg.equalsIgnoreCase("bye")){
                    System.out.println("클라이언트가 나갔습니다.");
                    break;
                }
                //정상 메세지인 경우
                System.out.println("클라이언트 : " + inMsg);
                System.out.println("보내기 >>");
                String outMsg = sc.nextLine();
                out.write(outMsg + "\n");
                out.flush();
            }
        } catch (IOException e) {
            //1000 Auto-generated catch block
            e.printStackTrace();
        } finally {
            try{
                sc.close();
                out.close();
                in.close();
                socket.close();
                server.close();

            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
 }
