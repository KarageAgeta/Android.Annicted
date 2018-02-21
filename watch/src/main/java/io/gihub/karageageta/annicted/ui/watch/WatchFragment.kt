package io.gihub.karageageta.annicted.ui.watch

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.karageageta.annicted.AnnictedApplication
import io.github.karageageta.annicted.R
import io.github.karageageta.annicted.di.DaggerWatchComponent
import io.github.karageageta.annicted.di.WatchPresenterModule
import io.github.karageageta.network.model.data.Work
import kotlinx.android.synthetic.main.fragment_watch.*
import javax.inject.Inject

class WatchFragment : Fragment(), WatchContract.View {
    companion object {
        fun newInstance() = WatchFragment()
    }

    @Inject lateinit var presenter: WatchContract.Presenter
    lateinit var adapter: WorkListRecyclerAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerWatchComponent.builder()
                .appComponent((activity?.application as AnnictedApplication).component)
                .watchPresenterModule(WatchPresenterModule(this))
                .build()
                .inject(this)
        adapter = WorkListRecyclerAdapter(context)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_watch, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_recycle.also {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = this.adapter
            view_recycle.emptyView = view_empty
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    // WatchContract.View

    override fun addWorks(work: List<Work>) {
        adapter.addAll(work)
    }
}
