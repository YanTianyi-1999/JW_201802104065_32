package lifter;
//该类用于测试显示时间的方法
public class TimeTest {
    public static void main(String[] args){
        java.util.Calendar c=java.util.Calendar.getInstance();
        //yyyy表示年(year),MM表示月(month),HH表示24小时制(hour),如果换成hh表示12小时制 ,mm表示分钟(mintue),ss表示秒(second)
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        System.out.println(f.format(c.getTime()));
    }
}
