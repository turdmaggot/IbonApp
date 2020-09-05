package com.raksoct.ibonapp.ListviewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.raksoct.ibonapp.Objects.Category;
import com.raksoct.ibonapp.Objects.Choice;
import com.raksoct.ibonapp.R;

import java.util.List;

/**
 * Created by Reiner on 8/7/2015.
 */
public class lvChoicesSingleAdapter extends BaseAdapter
{
    private LayoutInflater mInflater;
    List<Choice> choices;
    Context context;

    public lvChoicesSingleAdapter(Context context, List<Choice> choices)
    {
        this.choices = choices;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return choices.size();
    }

    @Override
    public Object getItem(int i)
    {
        return choices.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        View rootView = mInflater.inflate(R.layout.single_mode_choices_item, viewGroup, false);

        TextView txtChoice = (TextView) rootView.findViewById(R.id.txtChoice);

        txtChoice.setText(choices.get(i).getChoice());

        return rootView;
    }
}