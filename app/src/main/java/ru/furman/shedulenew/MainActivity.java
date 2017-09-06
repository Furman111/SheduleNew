package ru.furman.shedulenew;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    PagerAdapter pagerAdapter;

    public final static Calendar dateOfStudyingBeggining = new GregorianCalendar(2017, 9, 1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Calendar nowDate = new GregorianCalendar();
            nowDate.add(Calendar.DAY_OF_YEAR, position);
            int currentWeek = nowDate.get(Calendar.WEEK_OF_YEAR);
            currentWeek -= dateOfStudyingBeggining.get(Calendar.WEEK_OF_YEAR);
            currentWeek = Math.abs(currentWeek);
            currentWeek++;
            Log.d(PageFragment.LOG_TAG,"currentWeek = "+currentWeek);
            int currentDay = getDayOfWeek(nowDate);
            if (currentWeek % 2 == 0) {
                currentDay += 7;
            }
            return PageFragment.getInstance(currentDay);
        }

        private int getDayOfWeek(Calendar calendar){
            int currentDay = calendar.get(Calendar.DAY_OF_WEEK);
            if (currentDay == 1)
                currentDay = 7;
            else
                currentDay--;
            return currentDay;
        }

        @Override
        public int getCount() {
            return 14;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            int currentday = getDayOfWeek(Calendar.getInstance());
            currentday += position;
            currentday %= 7;
            String dayOfWeek = null;
            switch (currentday) {
                case 1:
                    dayOfWeek = getString(R.string.ponedelnik);
                    break;
                case 2:
                    dayOfWeek = getString(R.string.vtornik);
                    break;
                case 3:
                    dayOfWeek = getString(R.string.sreda);
                    break;
                case 4:
                    dayOfWeek = getString(R.string.chetverg);
                    break;
                case 5:
                    dayOfWeek = getString(R.string.pyatnica);
                    break;
                case 6:
                    dayOfWeek = getString(R.string.subbota);
                    break;
                case 0:
                    dayOfWeek = getString(R.string.voskresene);
                    break;
            }
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.add(Calendar.DAY_OF_YEAR, position);
            return dayOfWeek + " " + String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + "." + String.valueOf(calendar.get(Calendar.MONTH)+1);
        }
    }

}
