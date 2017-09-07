package cn.wsgwz.salarycomputer;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 2017/9/7 0007.
 */

public class SpinnerCategoryAdapter extends BaseAdapter implements SpinnerAdapter {
    private List<String> list;
    private Context context;

    public SpinnerCategoryAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        TextView text = new TextView(context);
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
        text.setText(list.get(i));
        text.setPadding(dp2px(16,context),dp2px(8,context),dp2px(16,context), 0);
        text.setMaxLines(1);
        text.setEllipsize(TextUtils.TruncateAt.END);
        constraintLayout.addView(text);


        return constraintLayout;
    }
    public static int dp2px(float value,Context context) {
        if(context == null) {
            return (int)value;
        } else {
            float scale = (float)context.getResources().getDisplayMetrics().densityDpi;
            return (int)(value * (scale / 160.0F) + 0.5F);
        }
    }

}
