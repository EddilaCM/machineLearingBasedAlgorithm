# 关联规则挖掘

* 语言：Java

* **FP_Growth 算法**

算法描述：

1. 统计交易数据中每一个Item的个数

2. 按统计结果从高到低对交易数据集中的每组Item 进行排序（先对统计结果进行排序，再对每条交易数据集进行排序）
3. 构建树
4. 根据设定的miniSupport(最小支持度)遍历树中每一个节点（即item）的count找出频繁项集
5. 根据设定的miniConfidence(最小置信度)从频繁项集中找到强关联规则






备注：package（Fp_growthTree）中包含两种树的建立方式！