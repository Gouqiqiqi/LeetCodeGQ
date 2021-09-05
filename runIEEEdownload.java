public class runIEEEdownload {
    public static void main(String[] args) {
        String[] namelist = new String[]{
                "https://ieeexplore.ieee.org/document/6784529",
                "https://ieeexplore.ieee.org/document/8116631",
                "https://ieeexplore.ieee.org/document/8428411",
                "https://ieeexplore.ieee.org/document/8884112/",
                " https://ieeexplore.ieee.org/document/5751589",
                "https://ieeexplore.ieee.org/document/6082361/",
                " https://ieeexplore.ieee.org/document/6663719/",
                " https://ieeexplore.ieee.org/document/8260980",
                " https://ieeexplore.ieee.org/document/6975117",
                " https://ieeexplore.ieee.org/document/8764555/",
                " https://ieeexplore.ieee.org/document/6547776",
                "https://ieeexplore.ieee.org/document/5738310",
                "https://ieeexplore.ieee.org/document/8392520/",
                "https://ieeexplore.ieee.org/document/5547005",
                "ttps://ieeexplore.ieee.org/document/4425798"
        };

        String http="https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=";
        for(int i =0; i <namelist.length ;i++){

            StringBuffer sb =new StringBuffer();
            String[] a = namelist[i].split("/");
            sb.append(http).append(a[a.length-1]);
            namelist[i]= sb.toString();
        }
        for(String x :namelist)
            System.out.println(x);

    }
    //    https://ieeexplore.ieee.org/document/6784529
//    https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=6784529

}