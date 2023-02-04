    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        Integer aPoints = 0;
        Integer bPoints = 0;
        
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) > b.get(i)) {
                aPoints++;
            }
            else if(a.get(i) < b.get(i)) {
                bPoints++;
            }
        }
        
        return Arrays.asList(aPoints, bPoints);
    }

}