class Solution {
    public int solution(int n, int k) {
        String convert = convertBase(n, k);
        return countSatisfying(convert);
    }

    private String convertBase(int n , int k) {
        StringBuilder sb = new StringBuilder();

        while(n >= k) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);

        return sb.reverse().toString();
    }

    private int countSatisfying(String convert) {
        String[] converts = convert.split("0");

        int count = 0;
         for(String part : converts) {
            if (part.isEmpty()) continue;
            long num = Long.parseLong(part);
            if(isPrimeNumber(num)) count++;
        }


        return count;
    }

/*  테스트1에서 시간 초과 발생
    private boolean isPrimeNumber(long convert) {
        if(convert < 2) return false;
        if(convert == 2) return true;

        for(int i = 2; i < convert/2; i++) {
            if(convert % i == 0) return false;
        }

        return true;
    }
*/

    private boolean isPrimeNumber(long convert) {
        if (convert < 2) return false;
        if (convert == 2) return true;

        for (long i = 2; i * i <= convert; i++) {
            if (convert % i == 0)
                return false;
        }

        return true;
    }
}