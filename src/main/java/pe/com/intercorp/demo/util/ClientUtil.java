package pe.com.intercorp.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.com.intercorp.demo.entity.ClientEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ClientUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientUtil.class);
    public static final String DATE_ONLY_FORMAT = "dd/MM/yyyy";

    public static double average(List<ClientEntity> list){
        return list.stream().collect(Collectors.averagingInt(ClientEntity::getAge));
    }

    public static double deviation(List<ClientEntity> list){
        Double average = average(list);
        Double deviation = 0.0;
        for(ClientEntity client : list){
            deviation += Math.pow((client.getAge() - average),2);
        }
        return Math.sqrt(deviation/list.size());
    }

    public static Date deathDate (ClientEntity client){
        int timeOfLive = Constant.TIME_OF_LIVE_MEAN - client.getAge();
        return addYear(addYear(client.getBirthday(), client.getAge()), timeOfLive);
    }

    public static Date addYear(Date date, int numYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, numYear);
        return calendar.getTime();
    }

    public static Date parseToDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_ONLY_FORMAT);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException ex) {
            LOGGER.error("Error parseando date " + date, ex);
        }
        return date;
    }
    public static String formatToDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_ONLY_FORMAT);
        return sdf.format(date);
    }
}
