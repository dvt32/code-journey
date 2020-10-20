// https://leetcode.com/problems/reformat-date/

class Solution {

    public String reformatDate(String date) {
        String[] dateParts = date.split(" ");

        String year = dateParts[2];
        
        String month = null;
        switch (dateParts[1]) {
            case "Jan": month = "01"; break;
            case "Feb": month = "02"; break;
            case "Mar": month = "03"; break;
            case "Apr": month = "04"; break;
            case "May": month = "05"; break;
            case "Jun": month = "06"; break;
            case "Jul": month = "07"; break;
            case "Aug": month = "08"; break;
            case "Sep": month = "09"; break;
            case "Oct": month = "10"; break;
            case "Nov": month = "11"; break;
            case "Dec": month = "12"; break;
            default: break;
        }
        
        String day = null;
        if (Character.isDigit(dateParts[0].charAt(1)))
        {
            day = "" + dateParts[0].charAt(0) + dateParts[0].charAt(1);
        }
        else {
            day = "0" + dateParts[0].charAt(0);
        }
            
        return year + "-" + month + "-" + day;
    }
    
}
