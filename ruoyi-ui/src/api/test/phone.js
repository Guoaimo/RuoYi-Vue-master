import request from '@/utils/request'

// 查询手机列表
export function listPhone(query) {
  return request({
    url: '/test/phone/list',
    method: 'get',
    params: query
  })
}

// 查询手机详细
export function getPhone(id) {
  return request({
    url: '/test/phone/' + id,
    method: 'get'
  })
}

// 新增手机
export function addPhone(data) {
  return request({
    url: '/test/phone',
    method: 'post',
    data: data
  })
}

// 修改手机
export function updatePhone(data) {
  return request({
    url: '/test/phone',
    method: 'put',
    data: data
  })
}

// 删除手机
export function delPhone(id) {
  return request({
    url: '/test/phone/' + id,
    method: 'delete'
  })
}
