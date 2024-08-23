package chat;
public class ClientEx{
    public static void main(String[] args) {
       
        Socket socket = null;
       BufferedReader in = null;
       BufeeredWriter out = null;
       Scanner sc = new Scanner(System.in);

       try {
           socket = new Socket("localhost", 9999);
           in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           out = new BufeeredWriter(new OutputStreamWriter(socket.getOutputStream()));

           while(true){
                System.out.println("보내기 >>");
                String outMsg = sc.nextLine();

                if(outMsg.equalsIgnoreCase("bye")){
                    out.write(outMsg + "\n");
                    out.flush();
                    break;
                }
                out.write(outMsg + "\n");
                out.flush();
            
                String inMsg = in.readLine();
                
                //정상 메세지인 경우
                System.out.println("서버 >> : " + inMsg);
               
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

            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}
