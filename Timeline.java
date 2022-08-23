public class Timeline {
    public static void main(String[] args){

        int[] ages = {6, 8, 10, 12, 14, 16};
        String[] events = {
                            "12/10 - Drove speedboat for the first time in Australia", 
                            "6/12 - Started taking piano lessons", 
                            "8/14 - Stopped Horseback riding because I got too scared :/", 
                            "4/16 - Went on a date with a girl for the first time",
                            "7/18 - Visited Iceland with my dad",
                            "5/21 - Made my first short movie"
                        };

        for (int i = 0; i < ages.length; i++) { 
            System.out.print(ages[i]);
            System.out.print("\t|\t");
            System.out.println(events[i]);

            for (int j = 0; j < 4; j++) {
                System.out.println();   
            }
        }
    }
}
