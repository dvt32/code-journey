// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

class Solution {
    
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        
        List<String> foldersAfterRemoving = new ArrayList<>();
        int i = 0;
        while (i < folder.length) {
            String currentMainFolder = folder[i];
            foldersAfterRemoving.add(currentMainFolder);
            i++;
            while (i < folder.length && folder[i].startsWith(currentMainFolder + "/")) {
                i++;
            }
        }
        
        return foldersAfterRemoving;
    }
    
}
