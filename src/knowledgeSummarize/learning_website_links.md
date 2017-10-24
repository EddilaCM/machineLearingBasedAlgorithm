

# SQL #
1. [十步完全理解 SQL](http://blog.jobbole.com/55086/)
2. [NoSQL](http://www.cnblogs.com/bldly1989/p/6721758.html)










# Recomdation System
1. [推荐系统](http://www.52ml.net/tags/%E6%8E%A8%E8%8D%90%E7%B3%BB%E7%BB%9F)
2. [从源代码剖析Mahout推荐引擎](http://blog.fens.me/mahout-recommend-engine/)
3. [用Maven构建Mahout项目](http://blog.fens.me/hadoop-mahout-maven-eclipse/)
4. [推荐算法的评价指标](http://blog.sina.com.cn/s/blog_92b0d7580102wtxa.html)
5. [ReLu(Rectified Linear Units)激活函数](http://www.cnblogs.com/neopenx/p/4453161.html)
6. [隐性反馈行为数据的协同过滤推荐算法](http://blog.csdn.net/lingerlanlan/article/details/46917601)
7. [推荐系统中基于深度学习的混合协同过滤模型](http://blog.csdn.net/xiewenbo/article/details/54710086)
9. [Mahout推荐算法API详解](http://blog.fens.me/mahout-recommendation-api/)
10. 








# Mearchine Learning
1. [数据挖掘十大算法详解](https://wizardforcel.gitbooks.io/dm-algo-top10/content/index.html)
2. [支持向量机SVM（一）](https://mp.weixin.qq.com/s?__biz=MzA5ODUxOTA5Mg==&mid=2652552896&idx=2&sn=713a10c17d15b3059fe160d9c0d35687&scene=19#wechat_redirect)



# Textual Analysis 
1. [深度学习与中文短文本分析总结与梳理](http://blog.csdn.net/wangyaninglm/article/details/66477222?locationNum=9&fps=1)
2. []()


# Math
1.[图论相关知识一](https://mp.weixin.qq.com/s?__biz=MzA5ODUxOTA5Mg==&mid=2652549028&idx=1&sn=1d2a736b34bf817fd659625a9782cd5d&scene=19#wechat_redirect "图论相关知识（一）")

	图(顶点和边组成)：有向图和无向图，连通图和不连通图
	网络：边上带权值；【边+~】
	度：与顶点相连的边的个数，有指向的时候也分为入度和出度【顶点+~】
	如果具有n个顶点，e条边的图G的顶点i的度为di，则G的边数为：
	$ e =\frac { \sum_{0}^{n-1} d_i} {2} $

	图主要有3种存储方式：
		（1）adjacent matrix(邻接矩阵)
		（2）adjacent list（邻接表）——稀疏图的时候可以节约空间，
			**其实就是用n个链表代替邻接矩阵中的n行**
		（3）adjacent multilist(邻接多重表)——无向图的存储！
	
	图的基本操作：
	- 广度优先搜索【按层处理节点：很像树的层次遍历】
	实现时，可以使用动态链接队列，队列中的每一个顶点都包含两个域：顶点的序号和链接指针。
	- 深度优先搜索
	



	eg:七桥问题【欧拉回环】、最大流、关键路径、最小生成树






