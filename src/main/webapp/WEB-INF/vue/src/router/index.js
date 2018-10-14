import Vue from 'vue'
import Router from 'vue-router'
import axios from 'axios'
import VueAxios from 'vue-axios'
import Home from '@/components/home/home'
import News from '@/components/news/news'
import Policy from '@/components/policy/policy'
import Public from '@/components/public/public'
import Product from '@/components/product/product'
import Association from '@/components/association/association'
import Enterprise from '@/components/enterprise/enterprise'
import Exhibition from '@/components/exhibition/exhibition'
import Tech from '@/components/tech/tech'
import Talent from '@/components/talent/talent'
import TalentJob from '@/components/talent/talent-job'
import TalentJDefault from '@/components/talent/talent-default'
import TalentApply from '@/components/talent/talent-apply'
import TalentList from '@/components/talent/talent-list'
import TalentInformation from '@/components/talent/talent-information'
import About from '@/components/about/about'
import Meeting from '@/components/meeting/meeting'
import industry_dynamic_text from '@/components/news/industry_dynamic_text'
import industry_dynamic from '@/components/news/industry_dynamic'



Vue.use(Router)
Vue.use(VueAxios, axios)

export default new Router({
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home,
      // alias:'/home',
    },//首页
    {
      path: '/news',
      name: 'news',
      component: News,
      // alias:'/news',
    },//资讯
    {
      path: '/policy',
      name: 'policy',
      component: Policy,
      // alias:'/policy',
    },//政策
    {
      path: '/industry_dynamic_text',
      name: 'industry_dynamic_text',
      component: industry_dynamic_text,
      // alias:'/industry_dynamic_text',
    },//行业动态正文      
    {
      path: '/industry_dynamic',
      name: 'industry_dynamic',
      component: industry_dynamic,
      // alias:'/industry_dynamic',
    },//行业动态
    {
      path: '/association',
      name: 'association',
      component: Association,
      // alias:'/association',
    },//协会
    {
      path: '/enterprise',
      name: 'enterprise',
      component: Enterprise,
      // alias:'/enterprise',
    }, //企业
    {
      path: '/product',
      name: 'product',
      component: Product,
    },//产品
    {
      path: '/public',
      name: 'poublic',
      component: Public,
    },//公众号
    {
      path: '/exhibition',
      name: 'exhibiton',
      component: Exhibition,
    },//展会
    {
      path: '/tech',
      name: 'tech',
      component: Tech,
    },//技术
    {
      path: '/talent',
      name: 'talent',
      component: Talent,
      children: [
        {
          path: '/',
          name: 'talent-default',
          component: TalentJDefault,
        },//人才主页
        {
          path: 'talent-job',
          name: 'talent-job',
          component: TalentJob,
        },//最新招聘
        {
          path: 'talent-apply',
          name: 'talent-apply',
          component: TalentApply,
        },//职位招聘
        {
          path: 'talent-information',
          name: 'talent-information',
          component: TalentInformation,
        },//个体详细信息
        {
          path: 'talent-list',
          name: 'talent-list',
          component: TalentList,
        },//专家库、高校
      ]
    },//人才
    {
      path: '/about',
      name: 'about',
      component: About,
    },//关于我们
    {
      path: '/meeting',
      name: 'meeting',
      component: Meeting,
    },//会议
    {
      path: '/',
      // component: Home,
      redirect: Home,
    }
  ],
  mode: "history"
})
