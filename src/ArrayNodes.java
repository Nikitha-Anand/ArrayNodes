import java.util.Scanner;

public class ArrayNodes {

    public ArrayNodes(){

    }

    public static Integer [] [] ArrayNodes = new Integer[20][3];
    public static Integer RootPointer = -1;
    public static Integer FreeNode = 0;

    public static void AddNode(){
        System.out.println("Enter the Data");
        int NodeData;
        Scanner in = new Scanner(System.in);
        NodeData = in.nextInt();
        if(FreeNode <= 19){
            ArrayNodes[FreeNode][0] = -1;
            ArrayNodes[FreeNode][1] = NodeData;
            ArrayNodes[FreeNode][2] = -1;
            if (RootPointer == -1){
                RootPointer = 0;
            }else{
                boolean Placed = false;
                Integer CurrentNode = RootPointer;
                while(!Placed){
                    if (NodeData < ArrayNodes[CurrentNode][1]){
                        if (ArrayNodes[CurrentNode][0] == -1){
                            ArrayNodes[CurrentNode][0] = FreeNode;
                            Placed = true;
                        }else{
                            CurrentNode = ArrayNodes[CurrentNode][0];
                        }
                    }else{
                        if (ArrayNodes[CurrentNode][2] == -1){
                            ArrayNodes[CurrentNode][2] = FreeNode;
                            Placed = true;
                        }else{
                            CurrentNode = ArrayNodes[CurrentNode][2];
                        }
                    }
                }
            }
            FreeNode = FreeNode + 1;
        }else{
            System.out.println("Tree is full");
        }
    }

    public static void PrintAll(){
        int i =0;
        while (ArrayNodes[i][1] != null) {
            System.out.println(ArrayNodes[i][0]+ "     "+ArrayNodes[i][1]+ "     "+ArrayNodes[i][2]);
            i++;
        }
    }
    public static void InOrder(Integer Root){
        if (ArrayNodes[Root][0] != -1){
            InOrder(ArrayNodes[Root][0]);
        }
        System.out.println(ArrayNodes[Root][1]);
        if(ArrayNodes[Root][2] != -1){
            InOrder(ArrayNodes[Root][2]);
        }
    }

    public static void main(String[] args){

        for (int i = 0; i < 10; i++) {
            AddNode();
        }
        PrintAll();
        System.out.println();
        InOrder(RootPointer);
    }
}
