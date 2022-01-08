package com.example.thesis.adapters;

import android.widget.Filter;

import com.example.thesis.models.Vaccine;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    VaccinesAdapter adapter;
    ArrayList<Vaccine> filterList;

    public CustomFilter(ArrayList<Vaccine> filterList, VaccinesAdapter adapter) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if (constraint != null && constraint.length() > 0) {

            constraint = constraint.toString().toUpperCase();

            ArrayList<Vaccine> filteredData = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                //CHECK
                if (filterList.get(i).getName().toUpperCase().contains(constraint)) {

                    filteredData.add(filterList.get(i));
                }
            }
            results.count = filteredData.size();
            results.values = filteredData;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.arrayVaccines = (ArrayList<Vaccine>) results.values;
        adapter.notifyDataSetChanged();
    }
}
