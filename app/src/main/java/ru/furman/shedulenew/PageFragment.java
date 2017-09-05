package ru.furman.shedulenew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by furman on 05.09.17.
 */

public class PageFragment extends Fragment {

    public static final String ARGUMENT_DAY_IN_SHEDULE = "day";

    private int day;

    private LinearLayout linearLayout;
    private LayoutInflater layoutInflater;

    public static PageFragment getInstance(int day){
        PageFragment pageFragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_DAY_IN_SHEDULE,day);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        day = getArguments().getInt(ARGUMENT_DAY_IN_SHEDULE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutInflater = inflater;
        View resView = layoutInflater.inflate(R.layout.fragment,null);
        linearLayout = resView.findViewById(R.id.ll);
        if(day==7 && day==14){
            //добавить обозначение выходного
        }
        else
            switch (day) {
                case 1:
                    //addperiod,addperiod,addperiod....
            }
        return resView;
    }

    private void addPeriod(int numberOfPeriod, String periodName,@Nullable String audience,@Nullable String teacher){
        View period = layoutInflater.inflate(R.layout.lesson_item_in_list,linearLayout,true);
        linearLayout.addView(period);
        ((TextView)period.findViewById(R.id.lesson_name_tv)).setText(periodName);
        if(audience!=null)
            ((TextView)period.findViewById(R.id.audience_tv)).setText(audience);
        if(teacher!=null)
            ((TextView)period.findViewById(R.id.teacher_name_tv)).setText(teacher);
        switch (numberOfPeriod){
            case 1:
                ((TextView)period.findViewById(R.id.time_tv)).setText(getString(R.string.first_period_time));
                break;
            case 2:
                ((TextView)period.findViewById(R.id.time_tv)).setText(getString(R.string.second_period_time));
                break;
            case 3:
                ((TextView)period.findViewById(R.id.time_tv)).setText(getString(R.string.third_period_time));
                break;
            case 4:
                ((TextView)period.findViewById(R.id.time_tv)).setText(getString(R.string.fourth_period_time));
                break;
            case 5:
                ((TextView)period.findViewById(R.id.time_tv)).setText(getString(R.string.fifth_period_time));
                break;
            case 6:
                ((TextView)period.findViewById(R.id.time_tv)).setText(getString(R.string.sixth_period_time));
                break;
        }
    }
}
