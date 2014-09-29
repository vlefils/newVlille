package com.iagl.newvlille.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iagl.newvlille.R;
import com.iagl.newvlille.adapter.StationListAdapter;
import com.iagl.newvlille.asyncTask.UpdatePlacesVelos;
import com.iagl.newvlille.asyncTask.UpdateStationList;
import com.iagl.newvlille.data.Station;

public class AllFragment extends Fragment{

    List<Station> stationsList;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		final View rootView = inflater.inflate(R.layout.fragment_all, container,
				false);

        stationsList=new ArrayList<Station>();
        

        UpdateStationList task = new UpdateStationList();
        try {
            stationsList = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
        ListView stationListView=(ListView)rootView.findViewById(R.id.listView1);
        
        for(Station s : stationsList){
            UpdatePlacesVelos task2 = new UpdatePlacesVelos();
            try {
                s.setDetail(task2.execute(s).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }     

            StationListAdapter adapter = new StationListAdapter(getActivity(),stationsList);

            stationListView.setAdapter(adapter);
        }


        
        
        
        return rootView;
	}

	  
}
