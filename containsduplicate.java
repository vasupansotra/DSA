class Solution {
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums){
        //    list.add(num);
        //    list.remove(list.size() - 1);
           if(list.contains(num)) return true;
           list.add(num);s
        }
        return false;
    }
}