package ru.furman.shedulenew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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
            TextView dayOffTv = new TextView(getContext());
            dayOffTv.setTextSize(20);
            dayOffTv.setText("Выходной");
            dayOffTv.setLayoutParams(linearLayout.getLayoutParams());
            linearLayout.addView(dayOffTv);
        }
        else
            switch (day) {
                case 1:
                    addPeriod(1, "Военная подготовка", null, null, PRACTICE_TYPE);
                    addPeriod(2, "Военная подготовка", null, null, PRACTICE_TYPE);
                    addPeriod(3, "Военная подготовка", null, null, PRACTICE_TYPE);
                    break;
                case 2:
                    addPeriod(1, "Надёжность и качество программного обеспечения", "608-н.к.", "проф. Мостовой Я. А.", LECTURE_TYPE);
                    addPeriod(2, "Компьютерная алгебра", "201-н.к.", "доц. Додонова Н. Л.", PRACTICE_TYPE);
                    addPeriod(3,"Надёжность и качество программного обеспечения","608-н.к.",null,PRACTICE_TYPE);
                    break;
                case 3:
                    addPeriod(1,"Теория цифровой обработки сигналов и изображений","608-н.к.",null,PRACTICE_TYPE);
                    addPeriod(2,"Исследование операций и теория игр","421-14",null,PRACTICE_TYPE);
                    addPeriod(3,"Базы данных","210-15","1) 3,7,11,15\n2) 5,9,13,17",LAB_TYPE);
                    addPeriod(4,"Базы данных","210-15","1) 3,7,11,15\n2) 5,9,13,17",LAB_TYPE);
                    break;
                case 4:
                    addPeriod(1,"Безопасность сетей ЭВМ","503-14","Кузнецов М. В.",LECTURE_TYPE);
                    addPeriod(2,"Безопасность сетей ЭВМ","503-14","Кузнецов М. В.",LECTURE_TYPE);
                    addPeriod(3, "Компьютерная алгебра", "503-14", "проф. Чернов В. М.", LECTURE_TYPE);
                case 5:
                    addPeriod(2,"Теория цифровой обработки сигналов и изображений","201-н.к.","доц. Чичева М. А.",LECTURE_TYPE);
                    addPeriod(3,"Теория цифровой обработки сигналов и изображений","201-н.к.","доц. Чичева М. А.",LECTURE_TYPE);
                    addPeriod(4,"Исследование операций и теория игр","502-14","доц. Есипов Б. А.",LECTURE_TYPE);
                    break;
                case 6:
                    addPeriod(1,"Основы управленческой деятельности","429-14","доц. Голубева Т.В.",LECTURE_TYPE);
                    addPeriod(2,"Философия","429-14","доц. Огнев А. Н.",LECTURE_TYPE);
                    addPeriod(3,"Базы данных","517-14","доц. Додонов М. В.",LECTURE_TYPE);
                    break;
                case 1+7:
                    addPeriod(1, "Военная подготовка", null, null, PRACTICE_TYPE);
                    addPeriod(2, "Военная подготовка", null, null, PRACTICE_TYPE);
                    addPeriod(3, "Военная подготовка", null, null, PRACTICE_TYPE);
                    break;
                case 2+7:
                    addPeriod(1,"Надёжность и качество программного обеспечения ▌ Базы данных","102-3; 519-14","1) 2,6,10,14 ▌ 4,8,12,16\n2) 4,8,12,16 ▌ 2,6,10,14",LAB_TYPE);
                    addPeriod(2,"Надёжность и качество программного обеспечения ▌ Базы данных","102-3; 519-14","1) 2,6,10,14 ▌ 4,8,12,16\n2) 4,8,12,16 ▌ 2,6,10,14",LAB_TYPE);
                    addPeriod(3,"Надёжность и качество программного обеспечения","513-3а","проф. Мостовой Я. А.",LECTURE_TYPE);
                    break;
                case 3+7:
                    addPeriod(4,"Компьютерная алгебра","608-н.к.","проф. Чернов В. М.",LECTURE_TYPE);
                    addPeriod(5,"Исследование операций и теория игр","430-14","доц. Есипов Б. А.",LECTURE_TYPE);
                    addPeriod(6,"Исследование операций и теория игр","430-14","доц. Есипов Б. А.",LECTURE_TYPE);
                    break;
                case 4+7:
                    addPeriod(1,"Теория цифровой обработки сигналов и изображений","608-н.к.","доц. Чичева М. А.",LECTURE_TYPE);
                    addPeriod(2,"Базы данных","517-14","доц. Додонов М. В.",LECTURE_TYPE);
                    addPeriod(3,"Компьютерная алгебра","517-14","проф. Чернов В. М.",LECTURE_TYPE);
                    break;
                case 5+7:
                    addPeriod(3,"Теория цифровой обработки сигналов и изображений","201-н.к.",null,PRACTICE_TYPE);
                    addPeriod(4,"Философия","419-14",null,PRACTICE_TYPE);
                    addPeriod(5,"Основы управленческой деятельности","502-14","доц. Голубева Т.В.",LECTURE_TYPE);
                    break;
                case 6+7:
                    addPeriod(3,"Безопасность сетей ЭВМ","102, 102а - 3",null,LAB_TYPE);
                    addPeriod(4,"Безопасность сетей ЭВМ","102, 102а - 3",null,LAB_TYPE);
                    break;
            }
        return resView;
    }

    public static final int LECTURE_TYPE = 1;
    public static final int PRACTICE_TYPE = 2;
    public static final int LAB_TYPE = 3;

    private void addPeriod(int numberOfPeriod, String periodName,@Nullable String audience,@Nullable String teacher,int periodType){
        View period = layoutInflater.inflate(R.layout.lesson_item_in_list,linearLayout,true);
        switch (periodType){
            case LECTURE_TYPE:
                period.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.lecture_color));
                break;
            case PRACTICE_TYPE:
                period.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.practice_color));
                break;
            case LAB_TYPE:
                period.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.lab_color));
                break;
        }
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
