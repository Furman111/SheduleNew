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

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    PagerAdapter pagerAdapter;

    public final static Calendar dateOfStudyingBeggining = new GregorianCalendar(2017,9,1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }

    private  class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            int currentday = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
            currentday-=dateOfStudyingBeggining.get(Calendar.DAY_OF_YEAR)+1;
            currentday = Math.abs(currentday);
            currentday%=14;
            currentday+=position;
            return PageFragment.getInstance(currentday);
        }

        @Override
        public int getCount() {
            return 14;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            int currentday = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
            currentday+=position;
            if(currentday>7)
                currentday%=7;
            String dayOfWeek = null;
            switch (currentday){
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
                case 7:
                    dayOfWeek = getString(R.string.voskresene);
                    break;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM", Locale.UK);
            return dayOfWeek+" "+ formatter.format(new Date());
        }
    }

}
