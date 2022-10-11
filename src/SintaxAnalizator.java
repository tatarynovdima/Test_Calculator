import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.lang.Math;


public class SintaxAnalizator {

    /**
     *  Программа анализатор, обрабатывающий арифметические выражения.
     *  Выражение, которые будут обрабатываться данным анализатором
     *  состоят из следующих элементов:
     *      1.  числа
     *      2.  операторы (+, -, *, /, ^(возведение в степень),
     *          % (остаток от деления), = (присваивание значения)
     *      3.  круглые скобки ()
     *      4.  переменные
     *  Ниже показано несколько примеров
     *      1.  10 - 8
     *      2.  (100 - 5) * 14 / 6
     *      4.  10 ^ 5
     *      5.  a = 10 - b
     *  Приоритеты операций, от высшего к низшему
     *      1.  +,- (унарные, к примеру a++, ++a)
     *      2.  ^
     *      3.  *, /, %
     *      4.  +,-
     *      5.  =
     *
     * @throws ParserException
     *
     *
     */
    public static void main(String[] args) throws ParserException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser myParser = new Parser();

        for(;;)
        {
            try
            {
                System.out.print("Enter math expression \n-> ");
                String str = reader.readLine();
                if(str.equals(""))
                    break;
                double result = myParser.evaluate(str);

                DecimalFormatSymbols s = new DecimalFormatSymbols();
                s.setDecimalSeparator('.');
                DecimalFormat f = new DecimalFormat("#,##0.00", s);


                System.out.printf("%s = %s%n", str, f.format(result));

            }
            catch(ParserException e)
            {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

}