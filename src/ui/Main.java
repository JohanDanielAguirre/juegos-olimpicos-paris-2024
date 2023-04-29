package ui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import model.Controller;
import model.Country;

public class Main {
    private Controller c;
    public static Scanner sc = new Scanner(System.in);

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Main() {

        Controller c= new Controller();
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.mainMenu();
    }

    private void mainMenu() {
        boolean flag=true;
        int option=0;
        String info="";
        Controller c=new Controller();
        ArrayList<Country> Olimpic= new ArrayList<>();
        Olimpic=c.load();
        System.out.println("                                              || Sistema olimpico paris 2024 ||");
        System.out.println("                                                                                                       \n"
                + "                                                    ...:~~!7???JJJJ???7!~~:..\n"
                + "                                            .:~7?JYJ?7~^^:.^^.....:::^^~7JJYJ?!~:.                                                             \n"
                + "                                         .~7JJ77~:.  .     ..    ....   .. . .:~7JYY7^.                                                        \n"
                + "                                        .^7YY7^.      ...    :.   .^^:   .^.     ..   .^7JJ!^.                                                 \n"
                + "                                     .^JYJ~.         .^:   .:^ ......:...:..   ..         .^J5J^.                                              \n"
                + "                                   :?5J^          ..... ..         .        ....              ^J5?:                                            \n"
                + "                                .^Y5!.          ....             ~B#P.            ....          .!5Y^.                                         \n"
                + "                               ^55^         ....                 5#&#.                ...          ^55^.                                       \n"
                + "                             ^55^         ..                     .##B                    ...         ^55:                                      \n"
                + "                           .?G!         ..                       :&B&.                      ..         !G?.                                    \n"
                + "                         .^GY        ..                          !&B&!                         ..        YP^                                   \n"
                + "                        .!B~        .                            5&G&Y                          ..        ~B!.                                 \n"
                + "                       .?B:       ..                             #&G&B                            ..       :B7.                                \n"
                + "                      .?B.       .                              .5&?B#:                             .       .B?. \n"
                + "                      7B.       .                               ?P#?5&J                              .       .B7.                              \n"
                + "                    .^#.       :                               .PGGGY#B.                              :       .#^.                             \n"
                + "                    :B7       :                                Y#BG&55&7                               :       7B: \n"
                + "                    7B       .                                .##P5&G?&B^                               .       B7.                            \n"
                + "                   .#~       .                              5B##GBBPGP#BP^^                             .       ~#:                            \n"
                + "                  .~B       :                              ^&P##&G&&&&B&&&&J                             :       B~.                           \n"
                + "                  .YP       .                              :5G5BJ?#GGBJYGB5                              .       PY.                           \n"
                + "                  .P7       .                              ~&GG#J@@@@@@5#&BG.                            .       7P.                           \n"
                + "                  :B~       .                             7GGY&5B@@@@@@@J&&#G:                           .       ~B:                           \n"
                + "                  :B~       .                            !!55#P?@&@&@@@@&5B#&G^                          .       ~B:                           \n"
                + "                  .P7       .                          .PB7YB&5GJJYJB@@&@#5BBB#^                         .       7P.                           \n"
                + "                  .YP       .                     ^GPPPPB####GGP^:..~&&5#@P:?#BY7.                       .       PY.                           \n"
                + "                  .~B       :                     7&BBY55#GG&GGG&&#7?G&PG#&5GG#G#GJ?5J7                  :       B~.                           \n"
                + "                   :#~       .                   .PYP5PGPG5P5P5P5PPJJYP555BJY?P5PYYJBB~.                .       ~#:                            \n"
                + "                   .?#       ..                  ~7!J~?!!!!?7?!?!?!?7J!J7??JJYJJ555Y5Y5J.              ..       B?.                            \n"
                + "                    :B7       :                .~7P!YJ55!?7GJPY55YGJBYG5GP5G5G?57??Y?J??^              :       7G:                             \n"
                + "                    .^#:       .            .:?PY?JJY?!~?JB?5!7~~.^^^~?77?!Y?P?5JY!Y55Y7!^.           .       :#^ \n"
                + "                      7B.       .  .:~7??77J5B&&&&@@&?^Y55?7!?PG#BB#BB#BG7~^::.::~^^^!PPPYPY~.       .       .B?~~7?YJ?7!^..                   \n"
                + "                      .?B.      ^JJYYYY55PGPPGBB&@@G~~?JGB&&@@@@@@@@@@BJ~::.....  ..::!B@@@@G~:    .:       .GG5P5YY5P555J7~:.                 \n"
                + "         .:^           .?B: .^7JYY55YY5PPGGGGGBBY7!7P&&@@@@@@@@@@@&B?:.............:.:~?5B&&#P7   ..     :~JBGP55555PPPP5YYJ7~:                \n"
                + "          ^7^.          .?B?J5YYYYY55YYPGGGGBBBP~.^P#&@@@@@@@@@&G7...................^J55YPG&&? ..   .:!J5GBP5Y5PP5PP5555555Y7^                \n"
                + "          :7JJ??~....:^!?Y5GPYYY55YYY55PGGBBBBG5J~:::~5BBBB5Y?~....:.........:.......^7PBBP55#Y:^^^!JY5PPPGPP5555Y555555P555Y7:                \n"
                + "         .~?5PP5JJJJJYY5YJJ5PP5YYYY55YYGBBBBGPPBP7:  .:..::......  .......::::......  ^5BBBBGGPYY5Y5P5YPGG5PP55555PP5PP55555J!:                \n"
                + "         .~7JYJYYYYYYYJY5YYY55PG55YYJJJGBBPPPGBB57^::::...             ..:.....:...:  .!YGBBBBGP5YYYPPGGPP5YYP5PPP555P555555J!:                \n"
                + "         .^!?YYJJYY5555YYY5YY555PG5JJYYGBGPGGBBGPJ~....                   ::..:.....  .~7YPGGBG555PPGGP5Y5P55555555YP5555555J~:                \n"
                + "          :!JJYY5YYY5YY5YY5YJJYYJ5PP55YYYYY5555?^.                                    .^7Y55P5555GGPPP55P5YPPY555P5555PP5PPPY7~                \n"
                + "         .^!JY555YYY5YY5YJYYJJY5YYY5PPP5?!!7JY5J^.                                    .~JY5PP5PGGGP5P55555555555555J7!!?JYPPPJ~                \n"
                + "          :!JYY55555YYYYJJYYYYYY5J!^..^?5J~::^!7^.                                    .!JYPP5PGGPP555Y55555YP5Y?^..     .:!?J?.                \n"
                + "         .^!JY55YYJJJJYYYYYY55?~.       .^7YJ?7~:.                                    :?YGP55YY5PP55PP55PPPY!.             .^!^                \n"
                + "          .~!??JJJYYYY5555Y?~.              .^7?7~:.                             :~!J?!7?JJJ5Y5P5555PPPPJ~.                  .                 \n"
                + "           .:~!?JJYY5YJ?!^.                     ..:::.....    ..........:^~~7JJYJ?!~:.  .^~7?Y55PPP5Y7^.                                       \n"
                + "              .::^~^...                                  ....^??JJJJJJ??7!~~:..            .:^^^^^:.                                           \n");
        do{
            System.out.println("seleccione una opcion:                                                                                                   \n"
                    + "1. registrar pais\n"
                    + "2. mostrar medalleria                                                     \n"
                    + "3. mostrar total de medallas                          \n"
                    + "4. Mostrar paises    \n"
                    + "5. salir  \n");
            try {
                option=Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try{
				switch (option){
                case 1:
                    System.out.println("ingrese la informacion del pais en el formato pre establecido");
                    info=sc.next();
                    info= info.toLowerCase();
					try{
						 Olimpic=c.regcountry(info,Olimpic);
					}catch(Exception e){
						System.out.println(e);
					}
                   
                    break;
                case 2:
                    System.out.println(c.showmedals(Olimpic));
                    break;
                case 3:
                    System.out.println(c.listmedals(Olimpic));
                    break;
                case 4:
                    System.out.println(c.ordernames(Olimpic));
                    break;
                case 5:
                    c.savedata(Olimpic);
                    flag=false;
                    break;
					default:
						System.out.println("numero invalido ingrese un numero que se encuentre dentro del listado");
					break;
				}
				
			}catch(InputMismatchException e){
				 System.out.println("informacion incorrecta por favor digite un valor valido");
			}
            
        }while (flag);

    }
}