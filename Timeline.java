public class Timeline {
    public static void main(String[] args){

        int[] ages = {6, 8, 10, 12, 14, 16};
        String[] events = {
                            "12/10 - Drove speedboat for the first time in Australia", 
                            "06/12 - Started taking piano lessons", 
                            "08/14 - Stopped Horseback ridig because I got too scared :/", 
                            "04/16 - Went on a date with a girl for the first time",
                            "07/18 - Visited Iceland with my dad",
                            "05/21 - Made my first short movie"
                        };

        System.out.println("\nAge\t|\tMM/YY - Description");
        System.out.println("\t|\t");

        for (int i = 0; i < ages.length; i++) { 
            System.out.print(ages[i]);
            System.out.print("\t|\t");
            System.out.println(events[i]);

            if (i < (ages.length - 1)) {
                for (int j = 0; j < 4; j++) {
                    System.out.println("\t|");   
                }
            }
        }

        System.out.println();
    }
}
