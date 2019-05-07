package Chart;

import java.util.LinkedList;

public class DeepFirstSort {
    GraphMatrix gm;
    boolean[] isVisited;

    DeepFirstSort(GraphMatrix gm){
        this.gm = gm;
        isVisited = new boolean[gm.getNumOfVertex()];
    }

    //私有函数，深度优先遍历
    private void depthFirstSearch(boolean[] isVisited,int  i) {
        //首先访问该结点，在控制台打印出来
        System.out.print(gm.getValueByIndex(i)+"  ");
        //置该结点为已访问
        isVisited[i]=true;

        int w = gm.getFirstNeighbor(i);//
        while (w!=-1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited,w);
            }
            w = gm.getNextNeighbor(i, w);
        }
    }

    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public void depthFirstSearch() {
        for(int i=0;i< gm.getNumOfVertex();i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                depthFirstSearch(isVisited,i);
            }
        }
        clearVisitRecord();
    }

    //私有函数，广度优先遍历
    private void broadFirstSearch(boolean[] isVisited,int i) {
        int u,w;
        LinkedList queue=new LinkedList();

        //访问结点i
        System.out.print(gm.getValueByIndex(i)+"  ");
        isVisited[i]=true;
        //结点入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u=((Integer)queue.removeFirst()).intValue();
            w= gm.getFirstNeighbor(u);
            while(w!=-1) {
                if(!isVisited[w]) {
                    //访问该结点
                    System.out.print(gm.getValueByIndex(w)+"  ");
                    //标记已被访问
                    isVisited[w]=true;
                    //入队列
                    queue.addLast(w);
                }
                //寻找下一个邻接结点
                w = gm.getNextNeighbor(u, w);
            }
        }
    }

    //对外公开函数，广度优先遍历
    public void broadFirstSearch() {
        for(int i=0;i < gm.getNumOfVertex();i++) {
            if(!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
        clearVisitRecord();
    }

    private void clearVisitRecord(){
        for(int i=0; i<isVisited.length; i++){
            isVisited[i] = false;
        }
    }
}
