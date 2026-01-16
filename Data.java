
import java.io.*;


public class Data
{

    static String user_db_txt_name=".\\Data\\user_db.txt";
    // static String admin_db_txt_name="admin_db.txt";

//alternative


    public static void WriteUser(String userparm,String passparm,String email){
        // String path= "out/production/booklibrary/db/user_db.txt";

        //if empty don't work
       /* if(userparm.isEmpty()||passparm.isEmpty()||email.isEmpty()){
            return; //return code no work
        }*/


        try (FileWriter fileWriter = new FileWriter(user_db_txt_name,true)) //the true for append
        {

            BufferedReader br = new BufferedReader(new FileReader(user_db_txt_name));
            if (br.readLine() == null) { //for empty file
                String newLogin=userparm+":"+passparm+":"+email;
                fileWriter.append(newLogin); //paste data on file
                fileWriter.flush();
                fileWriter.close();
            }else {
                String newLogin="\n"+userparm+":"+passparm+":"+email;
                fileWriter.append(newLogin);
                fileWriter.flush();
                fileWriter.close();
            }



        }

        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }





    public static boolean ValidateUser(String userparm,String passparm){
        File user_file=new File(user_db_txt_name); //#new File("out/production/booklibrary/db/user_db.txt");
        boolean isvalid=false; //default
        try
        {
            File file=user_file;    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            // StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;

            //     System.out.println(br.readLine());


            while((line=br.readLine())!=null)
            {

                //   System.out.println(line);

                String user =line.split(":")[0];
                String pass = line.split(":")[1];
                String email = line.split(":")[2];
                if(user.equals(userparm) && pass.equals(passparm)){
                    isvalid=true;
                }else {
                    isvalid=false;
                }
                //  System.out.println(user+" " +pass);
            }
            fr.close();    //closes the stream and release the resources

            // System.out.println(isvalid);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return isvalid;
    }

    public  static void DeleteUser( String user_parm,String pass_parm,String email_parm)
    {
       /* if(user_parm.isEmpty() || pass_parm.isEmpty() || email_parm.isEmpty()){
            return; //return code if blank
        }*/



        String oldString = user_parm+":"+pass_parm+":"+email_parm;

        //data hold string
        String newString=""; //blank don't change

        File fileToBeModified = new File(user_db_txt_name);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent



            writer = new FileWriter(fileToBeModified);

            String newCOtnentNEwlineRemooved = newContent.replaceAll("(?m)^\\s*$[\n\r]{1,}", ""); //for remove blank line from stirng

            writer.write(newCOtnentNEwlineRemooved);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }




}
