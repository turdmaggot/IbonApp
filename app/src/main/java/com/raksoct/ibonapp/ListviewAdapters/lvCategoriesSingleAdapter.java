package com.raksoct.ibonapp.ListviewAdapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.raksoct.ibonapp.Helpers.QuestionManager;
import com.raksoct.ibonapp.Objects.Category;
import com.raksoct.ibonapp.R;

import java.util.List;

/**
 * Created by Reiner on 8/6/2015.
 */
public class lvCategoriesSingleAdapter extends BaseAdapter
{
    private LayoutInflater mInflater;
    List<Category> categories;
    Context context;

    public lvCategoriesSingleAdapter(Context context, List<Category> places)
    {
        this.categories = places;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return categories.size();
    }

    @Override
    public Object getItem(int i)
    {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View rootView = mInflater.inflate(R.layout.single_mode_category_item, viewGroup, false);



        Category chosenCategory = categories.get(i);
        TextView txtCategory = (TextView) rootView.findViewById(R.id.txtCategory);
        RelativeLayout categoryRelLayout = (RelativeLayout)rootView.findViewById(R.id.categoryRelLayout);

        if (!chosenCategory.isHasQuestions())
        {
            categoryRelLayout.setBackgroundColor(Color.parseColor("#CCCCCC"));
        }

        txtCategory.setText(QuestionManager.RomanNumerals(chosenCategory.getID()) + ". " + chosenCategory.getTitle());

        return rootView;
    }
}