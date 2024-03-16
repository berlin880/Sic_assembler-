////Abdelrahman Adel Hassan (pablo:))



import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.*;


public class App {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String line;
            int c = 0;
            int b = 0;
            int a = 0;
            int ll = 0;
//            int asc;
            String hx, hx1="", k="", u="", ht="";
            String bb;
            String [] str;
            String [] t;
            char [] tt;
            Scanner s = new Scanner(new File("inSIC.txt"));//readd file
            Path path = Paths.get("inSIC.txt"); //get file path 
            int l = (int) Files.lines(path).count();; //coount lines
            String [] x0 = new String[l];
            String [] x1 = new String[l];
            String [] x2 = new String[l];
            String [] x3 = new String[l];
            String [] x4 = new String[l];
            String[][] OPTAB = new String[59][3];
            OPTAB[0] = new String[] {"FIX", "1", "C4"};
            OPTAB[1] = new String[] {"FLOAT", "1", "C0"};
            OPTAB[2] = new String[] {"HIO", "1", "F4"};
            OPTAB[3] = new String[] {"NORM", "1", "C8"};
            OPTAB[4] = new String[] {"SIO", "1", "F0"};
            OPTAB[5] = new String[] {"TIO", "1", "F8"};
            OPTAB[6] = new String[] {"ADDR", "2", "90"};
            OPTAB[7] = new String[] {"CLEAR", "2", "B4"};
            OPTAB[8] = new String[] {"COMPR", "2", "A0"};
            OPTAB[9] = new String[] {"DIVR", "2", "9C"};
            OPTAB[10] = new String[] {"MULR", "2", "98"};
            OPTAB[11] = new String[] {"RMO", "2", "AC"};
            OPTAB[12] = new String[] {"SHIFTL", "2", "A4"};
            OPTAB[13] = new String[] {"SHIFTR", "2", "A8"};
            OPTAB[14] = new String[] {"SUBR", "2", "94"};
            OPTAB[15] = new String[] {"SVC", "2", "B0"};
            OPTAB[16] = new String[] {"TIXR", "2", "B8"};
            OPTAB[17] = new String[] {"ADD", "3", "18"};
            OPTAB[18] = new String[] {"ADDF", "3", "58"};
            OPTAB[19] = new String[] {"AND", "3", "40"};
            OPTAB[20] = new String[] {"COMP", "3", "28"};
            OPTAB[21] = new String[] {"COMPF", "3", "88"};
            OPTAB[22] = new String[] {"DIV", "3", "24"};
            OPTAB[23] = new String[] {"DIVF", "3", "64"};
            OPTAB[24] = new String[] {"J", "3", "3C"};
            OPTAB[25] = new String[] {"JEQ", "3", "30"};
            OPTAB[26] = new String[] {"JGT", "3", "34"};
            OPTAB[27] = new String[] {"JLT", "3", "38"};
            OPTAB[28] = new String[] {"JSUB", "3", "48"};
            OPTAB[29] = new String[] {"LDA", "3", "00"};
            OPTAB[30] = new String[] {"LDB", "3", "68"};
            OPTAB[31] = new String[] {"LDCH", "3", "50"};
            OPTAB[32] = new String[] {"LDF", "3", "70"};
            OPTAB[33] = new String[] {"LDL", "3", "08"};
            OPTAB[34] = new String[] {"LDS", "3", "6C"};
            OPTAB[35] = new String[] {"LDT", "3", "74"};
            OPTAB[36] = new String[] {"LDX", "3", "04"};
            OPTAB[37] = new String[] {"LPS", "3", "D0"};
            OPTAB[38] = new String[] {"MUL", "3", "20"};
            OPTAB[39] = new String[] {"MULF", "3", "60"};
            OPTAB[40] = new String[] {"OR", "3", "44"};
            OPTAB[41] = new String[] {"RD", "3", "D8"};
            OPTAB[42] = new String[] {"RSUB", "3", "4C"};
            OPTAB[43] = new String[] {"SSK", "3", "EC"};
            OPTAB[44] = new String[] {"STA", "3", "0C"};
            OPTAB[45] = new String[] {"STB", "3", "78"};
            OPTAB[46] = new String[] {"STCH", "3", "54"};
            OPTAB[47] = new String[] {"STF", "3", "80"};
            OPTAB[48] = new String[] {"STI", "3", "D4"};
            OPTAB[49] = new String[] {"STL", "3", "14"};
            OPTAB[50] = new String[] {"STS", "3", "7C"};
            OPTAB[51] = new String[] {"STSW", "3", "E8"};
            OPTAB[52] = new String[] {"STT", "3", "84"};
            OPTAB[53] = new String[] {"STX", "3", "10"};
            OPTAB[54] = new String[] {"SUB", "3", "1C"};
            OPTAB[55] = new String[] {"SUBF", "3", "5C"};
            OPTAB[56] = new String[] {"TD", "3", "E0"};
            OPTAB[57] = new String[] {"TIX", "3", "2C"};
            OPTAB[58] = new String[] {"WD", "3", "DC"};
            System.out.println("File Content:- ");
            System.out.println("=================");
            while(s.hasNext()){
                line = s.nextLine();
                str = line.split("\t");
                x1 [c] = str [0];
                x2 [c] = str [1];
                x3 [c] = str [2];
                if(!str[0].isEmpty()){a++;}
                System.out.println(x1[c]+"-----"+x2[c]+"-----"+x3[c]);
                c++;
                
            }
            System.out.println("\n##############################################\n");

//######################################################################################################################

            System.out.println("Location Counter:- ");
            System.out.println("===================");
            x0[0] = x0[1] = x3[0]; //This line initializes the first and second elements of an array x0 to the value of the first element of another array x3. This probably sets the initial value of the location counter.
            for(int i=1;i<l-1;i++){
                if(x2[i].equals("RESW")){
                    x0[i+1] = Integer.toHexString(Integer.parseInt(x0[i],16)+(3*(Integer.parseInt(x3[i])))).toUpperCase();
                }
                else if(x2[i].equals("RESB")){
                    x0[i+1] = Integer.toHexString(Integer.parseInt(x0[i],16)+(Integer.parseInt(x3[i]))).toUpperCase();
                }
                else if(x2[i].equals("BYTE")){
                    t = x3[i].split("’");
                    if(t[0].equals("X")){b= (t[1].length())/2;}
                    else if(t[0].equals("C")){b=t[1].length();}
                    x0[i+1] = Integer.toHexString(Integer.parseInt(x0[i],16)+b).toUpperCase();
                }
                else if(x2[i].equals("WORD")){
                    x0[i+1] = Integer.toHexString(Integer.parseInt(x0[i],16)+3).toUpperCase();
                }
                else{
                    for(int j=0;j<59;j++){
                        if(x2[i].equals(OPTAB[j][0])){
                            x0[i+1] = Integer.toHexString(Integer.parseInt(x0[i],16)+(Integer.parseInt(OPTAB[j][1]))).toUpperCase();
                            break;
                        }
                    }
                }
            }
            for(int p=0; p<l;p++){
                System.out.println(x0[p]);
            }
            System.out.println("\n##############################################\n");

//######################################################################################################################

            System.out.println("Symbol Table (Symbol-----Location):-");
            System.out.println("=====================================");
            int d = 0;
            String[][] st = new String[a][2];
            for(int q=0;q<l;q++){
                if(!x1[q].isEmpty()){
                    st[d][0]=x1[q];
                    st[d][1]=x0[q];
                    d++;
                }
            }
            for(int w=0;w<a;w++){System.out.println(st[w][0]+"-----"+st[w][1]);}
            System.out.println("\n##############################################\n");

//######################################################################################################################

            System.out.println("Object Code:-");
            System.out.println("===============");
            for(int e=0;e<l;e++){
                if(x2[e].equals("RESW") || x2[e].equals("RESB") || x2[e].equals("Start") || x2[e].equals("End")){x4[e]="XXXXXX";}
                else if (x2[e].equals("WORD")){
                    hx = Integer.toHexString(Integer.parseInt(x3[e]));
                    if(hx.length()<6){for(int y=0;y<6-hx.length();y++){hx1+="0";}}
                    x4[e]=hx1+hx;
                    hx1="";
                }
                else if (x2[e].equals("BYTE")){
                    t = x3[e].split("’");
                    if(t[0].equals("X")){x4[e]=t[1];}
                    else if(t[0].equals("C")){
                        x4[e]=Integer.toHexString((int) t[1].charAt(0));
                        for (int r=1;r<t[1].length();r++){
                            int asc= (int) t[1].charAt(r);
                            x4[e] += Integer.toHexString((int) t[1].charAt(r));
                        }
                    }
                }
                else {
                    for(int j=0;j<59;j++){
                        if(x2[e].equals(OPTAB[j][0])){
                            u = OPTAB[j][2];
                            break;
                        }
                    }
                    for(int m=0;m<a;m++){
                        if(x3[e].equals(st[m][0])){
                            k = st[m][1];
                            break;
                        }
                    }
                    if (x2[e].equals("LDA") || x2[e].equals("STA") || x2[e].equals("LDCH") || x2[e].equals("STCH")) {
                        if(x3[e].contains(",X")){k = Integer.toHexString(Integer.parseInt(k,16)+Integer.parseInt("8000",16));}
//                        else {k = x0[e];}
                    }
                    if(x2[e].equals("RSUB")){k="XXXX";}
                    x4[e]=u+k;
                }
            }
            for(int n=0; n<l;n++){System.out.println(x4[n]);}
            System.out.println("\n##############################################\n");

//######################################################################################################################
            System.out.println("HTE Record:-");
            System.out.println("=============");
//            int v = 1;
            int ii=0;
            int cc = 1;
            int flag = 0;
            String kkk;
            int i1, i2;
            System.out.println("H^"+x1[0]+"^"+x3[0]+"^"+Integer.toHexString(Integer.parseInt(x0[l-1],16)-Integer.parseInt(x0[0],16)).toUpperCase());
            while(!x2[ii+1].equals("End") && c<=10) {
                if (!x2[ii].equals("RESW") && !x2[ii].equals("RESB")) {
                    ht += x4[ii] + " ";
                    cc++;
                    ii++;
                } else {
                    kkk = Integer.toHexString(Integer.parseInt(x0[ii], 16) - Integer.parseInt(x0[ii - cc], 16)).toUpperCase();
                    System.out.println("T^" + x0[ii - cc + 1] + "^" + kkk + "^" + ht);
                    cc = 1;
                    kkk = x0[ii - 1];
                    ht = x4[ii - 1] = "";
                }
            }
            System.out.println("E^"+x1[0]);
//            }
//            System.out.println("HTE Record:-");
//            System.out.println("=============");
////            int v = 1;
//            int ii=0;
//            int cc = 1;
//            int flag = 0;
//            String kkk;
//            int i1, i2;
//            for(int v=0;v<l;v++){
//                if(x2[v].equals("RESW") || x2[v].equals("RESB")){}
//                else if(cc<=10){
//                    ht += x4[v+1]+" ";
//                }
//            }
//            while(v<l){
//                if(!x2[v].equals("RESW") && !x2[v].equals("RESB") && (cc <= 10)) {
//                    ht += x4[v]+" ";
//                    cc++;
////                    ii++;
//                }
//
//                else{
//                    kkk = Integer.toHexString(Integer.parseInt(x0[v],16)-Integer.parseInt(x0[v-cc],16)).toUpperCase();
//                    System.out.println("T^"+x0[v-cc+1]+"^"+kkk+"^"+ht);
//                    cc=1;
//                    kkk=x0[v-1];
//                    ht=x4[v-1]=" ";
//                }
//                v++;

        }
        catch (FileNotFoundException e){System.out.println("File Not Found...");}
        catch (IOException e1){System.out.println("There is something went Wrong...");}
        }

        
}





