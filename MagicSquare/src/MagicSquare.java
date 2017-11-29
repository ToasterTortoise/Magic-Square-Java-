public class MagicSquare
{
    static final int MAX_ELEMENTS = 4;

    public static void main(String[] args)
    {
        int [] [] mSquare = {
                {1, 32, 36, 61},
                {62, 35, 31, 2},
                {63, 34, 30, 3},
                {4, 29, 33, 64}
        };
        PrintSquare(mSquare);
        CheckIfMagic(mSquare);
        System.out.println("\n\n****** End of xxPLP10 program *****");
    }

    static void PrintSquare(int[][] squareToPrint)
    {
        int i = 0;
        int j = 0;

        System.out.println("\nYour table");
        for(i =0; i < MAX_ELEMENTS; i++)
        {
            for(j = 0; j < MAX_ELEMENTS; j++)
            {
                System.out.printf("%4d ",squareToPrint[i][j]);
            }
            System.out.println();
        }
    }

    static boolean CheckIfMagic(int[][] squareToCheck)
    {
        int i = 0;
        int j = 0;
        int superSum = 0;
        int expectedValue = 0;

        // Get our value
        for(j = 0; j < MAX_ELEMENTS; j++)
        {
            expectedValue += squareToCheck[0][j];
        }

        // Horizontal check
        for(i = 0; i < MAX_ELEMENTS; i++)
        {
            superSum = 0;
            for(j = 0; j < MAX_ELEMENTS; j++)
            {
                superSum += squareToCheck[i][j];
            }
            if(superSum != expectedValue)
            {
                System.out.println("No magic");
                return false;
            }
        }

        // Vertical check
        for(i = 0; i < MAX_ELEMENTS; i++)
        {
            superSum = 0;
            for(j = 0; j < MAX_ELEMENTS; j++)
            {
                superSum += squareToCheck[j][i];
            }
            if(superSum != expectedValue)
            {
                System.out.println("No magic");
                return false;
            }
        }

        // first diagonal check
        superSum = 0;
        for(j = 0; j < MAX_ELEMENTS; j++)
        {
            superSum += squareToCheck[j][j];
        }
        if(superSum != expectedValue)
        {
            System.out.println("No magic");
            return false;
        }

        // second diagonal check
        superSum = 0;
        i = MAX_ELEMENTS - 1;
        for(j = 0; j < MAX_ELEMENTS; j++)
        {

            superSum += squareToCheck[i][j];
            i -= 1;
        }
        if(superSum != expectedValue)
        {
            System.out.println("No magic");
            return false;
        }



        System.out.println("Is magic");
        return true;
    }
}
