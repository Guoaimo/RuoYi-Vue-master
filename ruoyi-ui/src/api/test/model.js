import request from '@/utils/request'

// 查询型号列表
export function listModel(query) {
  return request({
    url: '/test/model/list',
    method: 'get',
    params: query
  })
}

// 查询型号详细
export function getModel(id) {
  return request({
    url: '/test/model/' + id,
    method: 'get'
  })
}

// 新增型号
export function addModel(data) {
  return request({
    url: '/test/model',
    method: 'post',
    data: data
  })
}

// 修改型号
export function updateModel(data) {
  return request({
    url: '/test/model',
    method: 'put',
    data: data
  })
}

// 删除型号
export function delModel(id) {
  return request({
    url: '/test/model/' + id,
    method: 'delete'
  })
}
